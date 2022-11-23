package entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@Getter
@Setter
public class Service {
    @Id @GeneratedValue
    private String idService;

    private String nomSI;

    @ManyToOne
    private Employe employe;

    public Service() {
    }

    public Service(String idService, String nomSI, Employe employe) {
        this.idService = idService;
        this.nomSI = nomSI;
        this.employe = employe;
    }
}
