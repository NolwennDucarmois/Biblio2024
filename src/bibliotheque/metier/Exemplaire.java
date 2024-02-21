package bibliotheque.metier;

import java.util.ArrayList;
import java.util.List;

public class Exemplaire {
    private String matricule;
    private String descriptionEtat;
    private Ouvrage ouvrage;
    private Rayon rayon;
    private List<Location> listLocation = new ArrayList<>();
    public Exemplaire(){

    }
    public Exemplaire(String matricule, String descriptionEtat, Ouvrage ouvrage){
        this.matricule=matricule;
        this.descriptionEtat=descriptionEtat;
        this.ouvrage=ouvrage;
    }


    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public String getDescriptionEtat() {
        return descriptionEtat;
    }

    public void setDescriptionEtat(String descriptionEtat) {
        this.descriptionEtat = descriptionEtat;
    }

    public Rayon getRayon() {
        return rayon;
    }

    public void setRayon(Rayon rayon) {
        this.rayon = rayon;
    }

    public List<Location> getListLocation() {
        return listLocation;
    }

    public void setListLocation(List<Location> listLocation) {
        this.listLocation = listLocation;
    }

    public void modifierEtat(String etat){

    }
    public void lecteurActuel(){

    }
    public void lecteurs(){

    }
    public void envoiMailLecteurActuel(Mail mail){

    }
    public void envoiMailLecteurs(Mail mail){

    }
    public boolean enRetard(){
        return true;
    }
    public int joursRetard(){
        return 0;
    }
    public boolean enLocation(){
        return true;
    }


}

