package services;

import entities.Contact;
import entities.Entreprise;
import entities.Fonction;
import org.springframework.stereotype.Service;

import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class Facade {
    @PersistenceContext
    EntityManager em;

    @Transactional
    public void addEntreprise(String nom, String siret, String addresse) {
        Entreprise entreprise = new Entreprise();
        entreprise.setAdresse(addresse);
        entreprise.setSiret(siret);
        entreprise.setNom(nom);
        entreprise.setMotsCles(List.of(nom, siret, addresse));
        em.persist(entreprise);
    }

    @Transactional
    public void addFunction(String intituleFonction) {
        Fonction fct = new Fonction();
        fct.setIntituleFonction(intituleFonction);
        em.persist(fct);
    }

    @Transactional
    public void addContact(String siret, String idFonction, String numTel, String nom, String prenom, String email) {
        Query q1 = em.createQuery("Select e from Entreprise e where e.siret=:siret");
        q1.setParameter("siret", siret);
        Entreprise e = (Entreprise) q1.getSingleResult();
        Fonction f = em.find(Fonction.class, Long.parseLong(idFonction));
        Contact contact = new Contact();
        contact.setFonction(f);
        contact.setEntreprise(e);
        contact.setNom(nom);
        contact.setEmail(email);
        contact.setPrenom(prenom);
        contact.setNumTelephone(numTel);
        //suffit car bidirectionnel

        em.persist(contact);
    }

    @Transactional
    public List<Entreprise> searchByMotCle(String motCle) {
        EntityGraph<Entreprise> eg = em.createEntityGraph(Entreprise.class);
        eg.addSubgraph("lesEchanges");
        eg.addSubgraph("lesVentes");
        eg.addSubgraph("lesContacts");


        Query q = em.createQuery("Select e from Entreprise e join e.motsCles mc where lower(mc) like CONCAT('%',:motcle,'%')");
        q.setParameter("motcle", motCle);
        q.setHint("javax.persistance.loadgraph", eg);


        return q.getResultList();

    }


    @Transactional
    public Entreprise getEntrepriseMaxContact() {
        EntityGraph<Entreprise> eg = em.createEntityGraph(Entreprise.class);
        eg.addSubgraph("lesEchanges");
        eg.addSubgraph("lesVentes");
        eg.addSubgraph("lesContacts");

        Query q = em.createQuery("Select e from Entreprise e where e.contacts.size =" +
                "(Select max(e.contacts.size) from Entreprise e)");
        q.setHint("javax.persistance.loadgraph", eg);
        return (Entreprise) q.getSingleResult();
    }

    public List<Fonction> getFonctions() {
        Query q = em.createQuery("Select f From Fonction f");

        return q.getResultList();
    }

    public List<Entreprise> getEntreprises() {
        Query q = em.createQuery("Select e From Entreprise e");

        return q.getResultList();
    }
}
