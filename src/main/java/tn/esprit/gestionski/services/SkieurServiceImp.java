package tn.esprit.gestionski.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.gestionski.entities.Cours;
import tn.esprit.gestionski.entities.Inscription;
import tn.esprit.gestionski.entities.Skieur;
import tn.esprit.gestionski.entities.TypeAbonnement;
import tn.esprit.gestionski.repositories.CourRepository;
import tn.esprit.gestionski.repositories.InscriptionRepository;
import tn.esprit.gestionski.repositories.SkieurRepository;

import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class SkieurServiceImp implements ISkieur{
    @Autowired
    private SkieurRepository skieurRepository;
    private CourRepository courRepository;
    private InscriptionRepository inscriptionRepository;


    @Override
    public Skieur addSkieur(Skieur s) {
        return skieurRepository.save(s);
    }

    @Override
    public Skieur updateSkieur(Skieur s) {
        return skieurRepository.save(s);
    }

    @Override
    public List<Skieur> findAllSkieur() {
        return skieurRepository.findAll();
    }

    @Override
    public Skieur findById(long numSkieur) {
        return skieurRepository.findById(numSkieur).orElse(null);
    }

    @Override
    public void deleteSkieur(long numSkieur) {
        skieurRepository.deleteById(numSkieur);
    }

    @Override
    public Skieur addSkieurAndAssignToCours(Skieur skieur, long numCours) {
        Skieur skieur1 = skieurRepository.save(skieur);
        Cours cours = courRepository.findById(numCours).orElse(null);
        List<Inscription> inscriptions= skieur1.getInscriptions();
                for (Inscription i:inscriptions){
                    i.setSkieurs(skieur1);
                    i.setCours(cours);
                    inscriptionRepository.save(i);
                }
        return skieur1;
    }
    @Override
    public List<Skieur> retreiveSkieurByTypeAbonnement(TypeAbonnement abonnement){
        return skieurRepository.findByAbonnement_TypeAbon(abonnement);
    }

    @Scheduled(fixedRate = 30000)
    public  void fixedRate(){
        log.info("method with fixed rate");
    }

    @Scheduled(cron = "0  36 16 * * *")
    public void cronMethod(){
        log.info("methode with Cron");
    }
}
