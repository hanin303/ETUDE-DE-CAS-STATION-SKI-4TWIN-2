package tn.esprit.gestionski.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tn.esprit.gestionski.entities.Inscription;
import tn.esprit.gestionski.entities.Skieur;
import tn.esprit.gestionski.entities.Support;

import java.util.List;

public interface InscriptionRepository extends JpaRepository<Inscription, Long> {
    @Query("select i.numSemaine from Inscription i "+
            " join Moniteur m" +
            " on i.cours member m.cours"+
            " where i.numInscription =:numMoniteur and i.cours.support =:support")
    List<Integer> numWeeksCourseOfInstructorBySupport(@Param("numMoniteur") Long numMoniteur, @Param("support") Support support);}
