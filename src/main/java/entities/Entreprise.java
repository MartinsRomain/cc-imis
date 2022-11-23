package entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class Entreprise {

    @Id @GeneratedValue
    private String idEntreprise;

    @OneToMany(mappedBy = "idVente")
    @Nullable
    private List<Vente> ventes;

    @OneToMany
    @Nullable
    private List<Contact> contacts;

    @OneToMany
    @Nullable
    private List<Echange> echanges;

    @ElementCollection
    @Nullable
    private List<String> motsCles;

    @Nullable
    private String nom, siret, adresse;

    public Entreprise() {
    }

    public Entreprise(String idEntreprise, List<Vente> ventes, List<Contact> contacts, List<Echange> echanges, List<String> motsCles, String nom, String siret, String adresse) {
        this.idEntreprise = idEntreprise;
        this.ventes = ventes;
        this.contacts = contacts;
        this.echanges = echanges;
        this.motsCles = motsCles;
        this.nom = nom;
        this.siret = siret;
        this.adresse = adresse;
    }
}
