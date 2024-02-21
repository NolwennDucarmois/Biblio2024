package bibliotheque.metier;

import java.time.LocalDate;

public class Location {
    private LocalDate dateLoc;
    private LocalDate dateRestitution;
    private double amende;
    private Lecteur lecteur;
    private Exemplaire exemplaire;
    public Location(){

    }

    public Location(LocalDate dateLoc, LocalDate dateRestitution, Lecteur lecteur, Exemplaire exemplaire) {
        this.dateLoc = dateLoc;
        this.dateRestitution = dateRestitution;
        this.lecteur = lecteur;
        this.exemplaire=exemplaire;
    }


    public LocalDate getDateLoc() {
        return dateLoc;
    }

    public void setDateLoc(LocalDate dateLoc) {
        this.dateLoc = dateLoc;
    }

    public LocalDate getDateRestitution() {
        return dateRestitution;
    }

    public void setDateRestitution(LocalDate dateRestitution) {
        this.dateRestitution = dateRestitution;
    }

    public double getAmende() {
        return amende;
    }

    public void setAmende(double amende) {
        this.amende = amende;
    }

    public Lecteur getLecteur() {
        return lecteur;
    }

    public void setLecteur(Lecteur lecteur) {
        this.lecteur = lecteur;
    }

    public Exemplaire getExemplaire() {
        return exemplaire;
    }

    public void setExemplaire(Exemplaire exemplaire) {
        this.exemplaire = exemplaire;
    }
    public void calculerAmende(){

    }
    public void enregistrerRetour(){

    }

    @Override
    public String toString() {
        return "Location{" +
                "dateLoc=" + dateLoc +
                ", dateRestitution=" + dateRestitution +
                ", amende=" + amende +
                ", lecteur=" + lecteur +
                ", exemplaire=" + exemplaire +
                '}';
    }
}
