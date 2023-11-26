package tn.esprit.gestionski.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Cours  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long numCours;
    private int niveau;
    private TypeCours typeCours;
    private Support support;
    private float prix ;
    private int creneau ;
    @OneToMany(mappedBy = "cours")
    @JsonBackReference
    private List<Inscription> inscription ;
//    @ManyToOne
//    private Moniteur moniteur ;
}
