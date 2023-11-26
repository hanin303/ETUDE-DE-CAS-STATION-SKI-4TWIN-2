package tn.esprit.gestionski.services;

import tn.esprit.gestionski.entities.Inscription;
import tn.esprit.gestionski.entities.Skieur;
import tn.esprit.gestionski.entities.Support;

import java.util.List;

public interface IInscription {
    public Inscription addInscriptionAndAssignToSkieur(Inscription inscription,long numSkieur);
    public Inscription addInscriptionAndAssignToCours(Inscription inscription,long numCours);

    public Inscription addRegistrationAndAssignToSkieurAndCourse(Inscription inscription, Long numSkieur, Long numCours);


    public Inscription updateInscription(Inscription inscription);

    public List<Inscription> findAllInscription();

    public Inscription findById(long  numInscription);

    public void deleteInscription(long numInscription);

    List<Integer> numWeeksCourseOfInstructorBySupport(Long numMoniteur , Support support);
    public void showMonthlyRecurringRevenue();
}
