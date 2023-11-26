package tn.esprit.gestionski.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tn.esprit.gestionski.entities.Abonnement;
import tn.esprit.gestionski.entities.TypeAbonnement;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface AbonnementRepository extends JpaRepository<Abonnement, Long> {
    @Query("select a from Abonnement a where a.typeAbon =:typeAbon order by a.dateDebut")
    List<Abonnement> getAbonnementByTypeAbon(@Param("typeAbon")TypeAbonnement typeAbonnement);

    List<Abonnement> findByDateDebutBetween(Date date1 , Date date2);
}
