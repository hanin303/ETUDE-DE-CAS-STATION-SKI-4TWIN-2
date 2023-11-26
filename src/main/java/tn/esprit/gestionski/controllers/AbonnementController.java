package tn.esprit.gestionski.controllers;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.gestionski.entities.Abonnement;
import tn.esprit.gestionski.entities.TypeAbonnement;
import tn.esprit.gestionski.services.AbonnementServiceImp;
import tn.esprit.gestionski.services.CoursServiceImp;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/Abonnement")
@AllArgsConstructor
public class AbonnementController {
    @Autowired
    private AbonnementServiceImp abonnementServiceImp;

  @GetMapping("getAbonnementByTypeAbon/{typeAbon}")
    public List<Abonnement> getAbonnementByTypeAbon(@PathVariable TypeAbonnement typeAbon){
        return abonnementServiceImp.getAbonnementByTypeAbon(typeAbon);
    }


    @GetMapping("findByDateDebutBetween/{date1}/{date2}")
    public List<Abonnement> findByDateDebutBetween(@PathVariable("date1") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date date1 , @PathVariable("date2") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date date2){
        return abonnementServiceImp.findByDateDebutBetween(date1 , date2);
    }

    @PostMapping("/retrieveSubscriptions")
    public ResponseEntity<String> retrieveSubscriptions() {
        abonnementServiceImp.retrieveSubscriptions();
        return ResponseEntity.ok("Subscription retrieval done successfully. Check the logs for details.");
    }
}
