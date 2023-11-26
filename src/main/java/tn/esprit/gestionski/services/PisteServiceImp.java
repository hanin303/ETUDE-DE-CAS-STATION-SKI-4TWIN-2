package tn.esprit.gestionski.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.gestionski.entities.Piste;
import tn.esprit.gestionski.entities.Skieur;
import tn.esprit.gestionski.repositories.PisteRepository;
import tn.esprit.gestionski.repositories.SkieurRepository;

import java.util.List;

@Service
@AllArgsConstructor

public class PisteServiceImp implements IPiste{

    public PisteRepository pisteRepository;
    public SkieurRepository skieurRepository;

    @Override
    public Piste addPiste(Piste p) {
        return  pisteRepository.save(p);
    }

    @Override
    public Piste updatePiste(Piste p) {
        return  pisteRepository.save(p);
    }

    @Override
    public List<Piste> findAllPiste() {
        return  pisteRepository.findAll();
    }

    @Override
    public Piste findById(long numPiste) {
        return  pisteRepository.findById(numPiste).orElse(null);
    }

    @Override
    public void deletePiste(long numPiste) {
        pisteRepository.deleteById(numPiste);
    }
    @Override
    public Skieur AssignSkieurToPiste(Long numSkieur, Long numPiste) {
        Skieur skieur = skieurRepository.findById(numSkieur).orElse(null);
        Piste piste = pisteRepository.findById(numPiste).orElse(null);
        skieur.getPistes().add(piste);
        piste.getSkieurs().add(skieur);
        skieurRepository.save(skieur);
        pisteRepository.save(piste);

        return skieur;

    }

}
