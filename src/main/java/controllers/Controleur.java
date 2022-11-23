package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import services.Facade;

@Controller
@RequestMapping("")
public class Controleur {
    @Autowired
    Facade facade;

    @RequestMapping("")
    public String root(){
        return "hello";
    }

    @GetMapping("createEntreprise")
    public String createEntrepriseGet(){
        return "createEntreprise";
    }

    @PostMapping("createEntreprise")
    public String createEntreprisePost(@RequestParam String siret, @RequestParam String nom, @RequestParam String adresse) {
        facade.addEntreprise(siret,nom,adresse);
        return "hello";
    }

    @GetMapping("createFonction")
    public String createFonctionGet(){
        return "createFonction";
    }

    @PostMapping("createFonction")
    public String createFonctionPost(@RequestParam String intitule){
        facade.addFunction(intitule);
        return "hello";
    }

    @GetMapping("createContact")
    public String createContactGet(Model model){
        model.addAttribute("entreprises",facade.getEntreprises());
        model.addAttribute("fonctions",facade.getFonctions());
        //  aller chercher la liste des entreprises et des fonctions dans la facade
        //  les ajouter dans le modèle
        return "createContact";
    }

    @PostMapping("createContact")
    public String createContactPost(@RequestParam String telephone, @RequestParam String entreprise,
                                    @RequestParam String fonction, @RequestParam String nom,
                                    @RequestParam String prenom, @RequestParam String email){
        facade.addContact(entreprise,fonction,telephone,nom,prenom,email);


        //  ajouter les paramètres de la méthode
        //  créer la méthode dans la facade
        return "hello";
    }

    @PostMapping("plusContact")
    public String plusContact(Model model){
        model.addAttribute("e",facade.getEntrepriseMaxContact());
        return "plusContact";
    }

    @PostMapping("parMotCle")
    public String parMotCle(@RequestParam String motcle,Model model){
        model.addAttribute("entreprises",facade.searchByMotCle(motcle));
        return "entreprises";
    }
}
