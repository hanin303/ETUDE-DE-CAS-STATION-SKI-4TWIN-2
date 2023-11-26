package tn.esprit.gestionski.services;

import tn.esprit.gestionski.entities.Piste;
import tn.esprit.gestionski.entities.Skieur;

import java.util.List;

public interface IPiste {
    public Skieur AssignSkieurToPiste(Long numskieur, Long numPiste);
    public Piste addPiste(Piste p);

    public Piste updatePiste(Piste p);

    public List<Piste> findAllPiste();

    public Piste findById(long  numPiste);

    public void deletePiste(long numPiste);
}
