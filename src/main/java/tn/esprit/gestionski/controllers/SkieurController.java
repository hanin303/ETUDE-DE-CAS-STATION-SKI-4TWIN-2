package tn.esprit.gestionski.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.gestionski.entities.Cours;
import tn.esprit.gestionski.entities.Inscription;
import tn.esprit.gestionski.entities.Skieur;
import tn.esprit.gestionski.entities.TypeAbonnement;
import tn.esprit.gestionski.services.SkieurServiceImp;

import java.util.List;

@RestController
@RequestMapping("/Skieur")
public class SkieurController {
    @Autowired
    private SkieurServiceImp skieurServiceImp;

    @PostMapping("/addSkieur")
    public Skieur addSkieur(@RequestBody Skieur s) {
        return skieurServiceImp.addSkieur(s);
    }

    @PutMapping("/updateSkieur")
    public Skieur updateSkieur(@RequestBody Skieur s) {
        return skieurServiceImp.updateSkieur(s);
    }

    @GetMapping("/getAll")
    public List<Skieur> findAllSkieur() {
        return skieurServiceImp.findAllSkieur();
    }

    @GetMapping("/get/{numSkieur}")
    public Skieur findById(@PathVariable long numSkieur) {
        return skieurServiceImp.findById(numSkieur);
    }

    @DeleteMapping("/delete/{numSkieur}")
    public void deleteSkieur(@PathVariable long numSkieur) {
        skieurServiceImp.deleteSkieur(numSkieur);
    }

    @PostMapping("/addSkieurAndAssignToCours/{numCours}")
    public Skieur addSkieurAndAssignToCours(@RequestBody Skieur skieur, @PathVariable long numCours){
        return skieurServiceImp.addSkieurAndAssignToCours(skieur,numCours);
    }
    @GetMapping("/retreiveSkieurByTypeAbonnement/{typeAbon}")
    public List<Skieur> retreiveSkieurByTypeAbonnement(@PathVariable TypeAbonnement typeAbon){
        return skieurServiceImp.retreiveSkieurByTypeAbonnement(typeAbon);
    }
}
