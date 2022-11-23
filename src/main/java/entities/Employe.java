package entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@DiscriminatorValue("Employe")
@Getter
@Setter
public class Employe extends Personne {
    @Id @GeneratedValue
    private String idEmploye;

    @OneToMany(mappedBy = "nomSI")
    private List<Service> services;

    @ManyToMany
    private List<Echange> echanges;

    public Employe() {
    }

    public Employe(String idEmploye, List<Service> services, List<Echange> echanges) {
        this.idEmploye = idEmploye;
        this.services = services;
        this.echanges = echanges;
    }
}
