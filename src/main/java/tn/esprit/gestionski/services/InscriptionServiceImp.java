package tn.esprit.gestionski.services;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.gestionski.entities.*;
import tn.esprit.gestionski.repositories.AbonnementRepository;
import tn.esprit.gestionski.repositories.CourRepository;
import tn.esprit.gestionski.repositories.InscriptionRepository;
import tn.esprit.gestionski.repositories.SkieurRepository;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor

public class InscriptionServiceImp implements IInscription{
    private InscriptionRepository inscriptionRepository;
    private SkieurRepository skieurRepository;
    private CourRepository coursRepository;
    public AbonnementRepository abonnementRepository;

    @Override
    public Inscription addInscriptionAndAssignToSkieur(Inscription inscription,long numSkieur) {
        Skieur sk = skieurRepository.getById(numSkieur);
        inscription.setSkieurs(sk);
        return inscriptionRepository.save(inscription);
    }
    @Override
    public Inscription addInscriptionAndAssignToCours(Inscription inscription,long numCours) {
        Cours cr = coursRepository.getById(numCours);
        inscription.setCours(cr);
        return inscriptionRepository.save(inscription);
    }

    @Override
    public Inscription updateInscription(Inscription inscription) {
        return inscriptionRepository.save(inscription);
    }

    @Override
    public List<Inscription> findAllInscription() {
        return inscriptionRepository.findAll();
    }

    @Override
    public Inscription findById(long numInscription) {
        return inscriptionRepository.findById(numInscription).orElse(null);
    }

    @Override
    public void deleteInscription(long numInscription) {
        inscriptionRepository.deleteById(numInscription);
    }


    @Override
    public List<Integer> numWeeksCourseOfInstructorBySupport(Long numMoniteur , Support support){
        return inscriptionRepository.numWeeksCourseOfInstructorBySupport(numMoniteur,support);
    }

    @Override
    public Inscription addRegistrationAndAssignToSkieurAndCourse(Inscription inscription, Long numSkieur, Long numCours) {

        Skieur skieur = skieurRepository.findById(numSkieur).orElse(null);
        Cours cours = coursRepository.findById(numCours).orElse(null);

        if (cours.getTypeCours() == TypeCours.COLLECTIF_ENFANT || cours.getTypeCours() == TypeCours.COLLECTIF_ADULTE) {

            if (cours.getInscription().size() >= 6) {
                return null;
            }
        }

        int skieurAge = calculateAge((Date) skieur.getDateNaissance());
        if (skieurAge < cours.getNiveau()) {
            return null;
        }

        inscription.setSkieurs(skieur);
        inscription.setCours(cours);
        coursRepository.save(cours);
        skieurRepository.save(skieur);
        return inscriptionRepository.save(inscription);
    }


    private int calculateAge(Date dateOfBirth) {
        if (dateOfBirth == null) {
            return 0;
        }
        java.util.Date utilDate = new java.util.Date(dateOfBirth.getTime());
        LocalDate birthDate = utilDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate currentDate = LocalDate.now();
        return Period.between(birthDate, currentDate).getYears();
    }

    private  Date calculateEndDateThreshold(Date currentDate) {
        long endDateMillis = currentDate.getTime() + (7L * 24L * 60L * 60L * 1000L);
        return new Date(endDateMillis);
    }
    @Override
    @Scheduled(cron = "0 0 0 1 * ?")
    public void showMonthlyRecurringRevenue() {
        Date currentDate = new Date();
        Date endDateThreshold = calculateEndDateThreshold(currentDate);

        List<Abonnement> endingSubscriptions = abonnementRepository.findByDateDebutBetween(currentDate, endDateThreshold);

        for (Abonnement abonnement : endingSubscriptions) {
            List<Skieur> skieurs = skieurRepository.findByAbonnement_TypeAbon(abonnement.getTypeAbon());

            for (Skieur skieur : skieurs) {
                System.out.println("Subscription Number: " + abonnement.getNumAbon());
                System.out.println("Skieur Information - NumSkieur: " + skieur.getNumSkieur() +
                        ", FirstName: " + skieur.getNomS() +
                        ", LastName: " + skieur.getPrenomS());
            }
        }
    }

    }
