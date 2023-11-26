package tn.esprit.gestionski.services;

import tn.esprit.gestionski.entities.Inscription;
import tn.esprit.gestionski.entities.Skieur;
import tn.esprit.gestionski.entities.TypeAbonnement;

import java.util.List;

public interface ISkieur {

    public Skieur addSkieur(Skieur s);

    public Skieur updateSkieur(Skieur s);

    public List<Skieur> findAllSkieur();

    public Skieur findById(long  numSkieur);

    public void deleteSkieur(long numSkieur);

    public Skieur addSkieurAndAssignToCours(Skieur skieur,long numSkieur);

    public List<Skieur> retreiveSkieurByTypeAbonnement(TypeAbonnement abonnement);

}
