package tn.esprit.gestionski.services;

import tn.esprit.gestionski.entities.Abonnement;
import tn.esprit.gestionski.entities.TypeAbonnement;

import java.util.Date;
import java.util.List;

public interface IAbonnement {

    public List<Abonnement> getAbonnementByTypeAbon(TypeAbonnement typeAbon);
    public List<Abonnement> findByDateDebutBetween(Date date1 , Date date2);
    public void retrieveSubscriptions();
}
