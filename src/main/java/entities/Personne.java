package entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Inheritance(strategy= InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TYPE_PERSONNE")
@Getter
@Setter
public class Personne {
    @Id
    @GeneratedValue
    private String idPersonne;

    private String nom, prenom, email;

    public Personne() {
    }

    public Personne(String idPersonne, String nom, String prenom, String email) {
        this.idPersonne = idPersonne;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
    }
}
