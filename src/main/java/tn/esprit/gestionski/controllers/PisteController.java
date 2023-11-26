package tn.esprit.gestionski.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.gestionski.entities.Piste;
import tn.esprit.gestionski.entities.Skieur;
import tn.esprit.gestionski.services.PisteServiceImp;
import java.util.List;

@RestController
@RequestMapping("/Piste")
public class PisteController {
    @Autowired
    private PisteServiceImp pisteServiceImp;

    @PostMapping("/addAssignSkieurToPiste/{numSkieur}/{numPiste}")
    public Skieur AssignSkieurToPiste(@PathVariable long numSkieur , @PathVariable long numPiste) {
        return pisteServiceImp.AssignSkieurToPiste(numSkieur, numPiste);
    }
    @PostMapping("/addPiste")
    public Piste addPiste(@RequestBody Piste p) {
        return  pisteServiceImp.addPiste(p);
    }

    @PutMapping("/updatePiste")
    public Piste updatePiste(@RequestBody Piste p) {
        return pisteServiceImp.updatePiste(p);
    }

    @GetMapping("/getAll")
    public List<Piste> findAllPiste() {
        return  pisteServiceImp.findAllPiste();
    }

    @GetMapping("/get/{numPiste}")
    public Piste findById(@PathVariable long numPiste) {
        return  pisteServiceImp.findById(numPiste);
    }

    @DeleteMapping("/delete/{numPiste}")
    public void deletePiste(@PathVariable long numPiste) {
        pisteServiceImp.deletePiste(numPiste);
    }
}
