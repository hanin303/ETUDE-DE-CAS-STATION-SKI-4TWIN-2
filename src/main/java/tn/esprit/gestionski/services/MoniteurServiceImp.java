package tn.esprit.gestionski.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.gestionski.entities.Cours;
import tn.esprit.gestionski.entities.Moniteur;
import tn.esprit.gestionski.repositories.CourRepository;
import tn.esprit.gestionski.repositories.MoniteurRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class MoniteurServiceImp implements IMoniteur{
    CourRepository courRepository;
    MoniteurRepository moniteurRepository;
    @Override
    public Moniteur addMoniteurAndAssignToCour(Moniteur moniteur , long numCours){
        Cours cours = courRepository.findById(numCours).orElse(null);
        List<Cours> coursSet = new ArrayList<>();
        coursSet.add(cours);
        moniteur.setCours(coursSet);
    return moniteurRepository.save(moniteur);
    }

}
