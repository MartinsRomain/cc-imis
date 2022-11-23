package entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Vente {
    @Id @GeneratedValue
    private String idVente;

    @Basic
    private LocalDateTime dateVente;

    @ManyToOne
    private Entreprise entreprise;

    private Integer montant;

    private String nature;

    public Vente() {
    }

    public Vente(String idVente, LocalDateTime dateVente, Entreprise entreprise, Integer montant, String nature) {
        this.idVente = idVente;
        this.dateVente = dateVente;
        this.entreprise = entreprise;
        this.montant = montant;
        this.nature = nature;
    }
}
