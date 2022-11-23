package entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Getter
@Setter
public class Fonction {
    @Id @GeneratedValue
    private String idFonction;

    @OneToMany(mappedBy = "idContact")
    private List<Contact> contact;

    private String intituleFonction;

    public Fonction() {
    }

    public Fonction(String idFonction, List<Contact> contact, String intituleFonction) {
        this.idFonction = idFonction;
        this.contact = contact;
        this.intituleFonction = intituleFonction;
    }
}
