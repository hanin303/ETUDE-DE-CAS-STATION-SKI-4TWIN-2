package tn.esprit.gestionski.services;

import tn.esprit.gestionski.entities.Moniteur;

public interface IMoniteur {
    public Moniteur addMoniteurAndAssignToCour(Moniteur moniteur , long numCours);
}
