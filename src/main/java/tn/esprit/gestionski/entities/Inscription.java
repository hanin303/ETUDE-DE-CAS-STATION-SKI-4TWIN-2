package tn.esprit.gestionski.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Inscription  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long numInscription;
    private int numSemaine;
    @ManyToOne
    @JsonIgnore
    private Cours cours ;
    @ManyToOne
    @JsonIgnore
    private Skieur skieurs ;

}
