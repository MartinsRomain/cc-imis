package entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
public class Echange {
    @Id @GeneratedValue
    private String idEchange;

    @ManyToMany
    @JoinTable(name = "CONTACT_ECHANGE",joinColumns = {@JoinColumn(name = "idEchange")},inverseJoinColumns = {@JoinColumn(name = "idContact")})
    private List<Contact> contacts;

    @ManyToOne
    private Entreprise entreprise;

    @ManyToMany
    @JoinTable(name = "EMPLOYE_ECHANGE",joinColumns = {@JoinColumn(name = "idEchange")},inverseJoinColumns = {@JoinColumn(name = "idEmploye")})
    private List<Employe> employes;

    @Basic
    private LocalDateTime dateEchange;

    private String compteRendu;

    public Echange() {
    }

    public Echange(String idEchange, List<Contact> contacts, Entreprise entreprise, List<Employe> employes, LocalDateTime dateEchange, String compteRendu) {
        this.idEchange = idEchange;
        this.contacts = contacts;
        this.entreprise = entreprise;
        this.employes = employes;
        this.dateEchange = dateEchange;
        this.compteRendu = compteRendu;
    }
}
