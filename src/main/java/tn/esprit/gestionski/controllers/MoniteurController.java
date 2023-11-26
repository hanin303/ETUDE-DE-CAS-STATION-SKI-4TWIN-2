package tn.esprit.gestionski.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.gestionski.entities.Moniteur;
import tn.esprit.gestionski.services.IMoniteur;

@RestController
@RequestMapping("/Moniteur")
@AllArgsConstructor
public class MoniteurController {
    IMoniteur iMoniteur;
    @PostMapping("/addMoniteurAndAssignToCour/{numCours}")
    public Moniteur addMoniteurAndAssignToCour(@RequestBody Moniteur moniteur , @PathVariable long numCours){
        return iMoniteur.addMoniteurAndAssignToCour(moniteur,numCours);
    }
}
