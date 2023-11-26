package tn.esprit.gestionski.controllers;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.gestionski.entities.Inscription;
import tn.esprit.gestionski.entities.Support;
import tn.esprit.gestionski.services.InscriptionServiceImp;
import java.util.List;

@RestController
@RequestMapping("/Inscription")
public class InscriptionController {
    @Autowired
    private InscriptionServiceImp inscriptionServiceImp;

        @PostMapping("/addInscriptionAndAssignToSkieur/{numSkieur}")
        public Inscription addInscriptionAndAssignToSkieur(@RequestBody Inscription i , @PathVariable Long numSkieur) {
            return inscriptionServiceImp.addInscriptionAndAssignToSkieur(i,numSkieur);
        }

    @PostMapping("/addInscriptionAndAssignToCours/{numCours}")
    public Inscription addInscriptionAndAssignToCours(@RequestBody Inscription i , @PathVariable Long numCours) {
        return inscriptionServiceImp.addInscriptionAndAssignToCours(i,numCours);
    }


    @PutMapping("/updateInscription")
    public Inscription updateInscription(@RequestBody Inscription i) {
        return inscriptionServiceImp.updateInscription(i);
    }

    @GetMapping("/getAll")
    public List<Inscription> findAllInscription() {
        return inscriptionServiceImp.findAllInscription();
    }

    @GetMapping("/get/{numInscription}")
    public Inscription findById(@PathVariable long numInscription) {
        return inscriptionServiceImp.findById(numInscription);
    }

    @DeleteMapping("/delete/{numSkieur}")
    public void deleteInscription(@PathVariable long numInscription) {
        inscriptionServiceImp.deleteInscription(numInscription);
    }


    @GetMapping("numWeeksCourseOfInstructorBySupport/{numMoniteur}/{support}")
    public List<Integer> numWeeksCourseOfInstructorBySupport(@PathVariable long numMoniteur , @PathVariable Support support){
            return  inscriptionServiceImp.numWeeksCourseOfInstructorBySupport(numMoniteur,support);
    }

    @PostMapping("/addRegistration/{numSkieur}/{numCours}")
    public Inscription addRegistrationAndAssignToSkieurAndCourse(@RequestBody Inscription inscription, @PathVariable Long numSkieur, @PathVariable Long numCours) {
        Inscription addInscription = inscriptionServiceImp.addRegistrationAndAssignToSkieurAndCourse(inscription, numSkieur, numCours);
        return addInscription;
    }

    @PostMapping("/showMonthlyRecurringRevenue")
    public ResponseEntity<String> showMonthlyRecurringRevenue() {
        inscriptionServiceImp.showMonthlyRecurringRevenue();
        return ResponseEntity.ok("reccurring revenue triggered successfully ! ");
    }
}
