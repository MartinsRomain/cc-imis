package entities;

import entities.Echange;
import entities.Entreprise;
import entities.Fonction;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@DiscriminatorValue("entities.Contact")
@Getter
@Setter
public class Contact extends Personne {
    @Id @GeneratedValue
    private String idContact;

    @ManyToOne
    private Entreprise entreprise;

    @ManyToMany
    private List<Echange> echange;

    @ManyToOne
    private Fonction fonction;

    private String numTelephone;

    public Contact() {
    }

    public Contact(String idContact, Entreprise entreprise, List<Echange> echange, Fonction fonction, String numTelephone) {
        this.idContact = idContact;
        this.entreprise = entreprise;
        this.echange = echange;
        this.fonction = fonction;
        this.numTelephone = numTelephone;
    }
}
