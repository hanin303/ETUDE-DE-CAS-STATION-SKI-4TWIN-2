package tn.esprit.gestionski.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Skieur implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long numSkieur;
    private String nomS;
    private String prenomS;
    @Temporal(TemporalType.DATE)
    private Date dateNaissance;
    private String ville ;
    @OneToOne
    private Abonnement abonnement ;
    @ManyToMany(mappedBy = "skieurs")
    @JsonIgnore
    private List<Piste> pistes;
    @OneToMany(mappedBy = "skieurs" , cascade = CascadeType.ALL) //cardinalite tethat fl entiter plus faible ( 1)
    @JsonBackReference
    private List<Inscription> inscriptions;



}
