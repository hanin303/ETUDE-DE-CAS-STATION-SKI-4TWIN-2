package tn.esprit.gestionski.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.gestionski.entities.Abonnement;
import tn.esprit.gestionski.entities.Skieur;
import tn.esprit.gestionski.entities.TypeAbonnement;
import tn.esprit.gestionski.repositories.AbonnementRepository;
import tn.esprit.gestionski.repositories.SkieurRepository;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class AbonnementServiceImp implements IAbonnement{
    @Autowired
    private AbonnementRepository abonnementRepository;
    @Autowired
    private SkieurRepository skieurRepository;


    @Override
    public List<Abonnement> getAbonnementByTypeAbon(TypeAbonnement abonnement) {
        return abonnementRepository.getAbonnementByTypeAbon(abonnement);
    }

    @Override
    public List<Abonnement> findByDateDebutBetween(Date date1 , Date date2) {
        return abonnementRepository.findByDateDebutBetween(date1,date2);
    }

    @Override
    @Scheduled(cron = "0 0 0 * * ?")
    public void retrieveSubscriptions() {
        Date currentDate = new Date();
        Date endDateThreshold = calculateEndDateThreshold(currentDate);

        // Retrieve subscriptions ending in the next 7 days
        List<Abonnement> endingSubscriptions = abonnementRepository.findByDateDebutBetween(currentDate, endDateThreshold);

        for (Abonnement abonnement : endingSubscriptions) {
            List<Skieur> skieurs = skieurRepository.findByAbonnement_TypeAbon(abonnement.getTypeAbon());

            for (Skieur skieur : skieurs) {
                // Display information or perform further processing
                System.out.println("Numéro de l’abonnement: " + abonnement.getNumAbon());
                System.out.println("les informations associées\n" + "au skieur: " + skieur.getNumSkieur() +
                        ", FirstName: " + skieur.getNomS() +
                        ", LastName: " + skieur.getPrenomS());
            }
        }
    }

    private Date calculateEndDateThreshold(Date currentDate) {
        // Calculate the date 7 days from the current date
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(currentDate);
        calendar.add(Calendar.DAY_OF_MONTH, 7);
        return calendar.getTime();
    }

}
