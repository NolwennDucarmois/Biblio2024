package bibliotheque.metier;

import java.util.*;

import static bibliotheque.metier.TypeOuvrage.LIVRE;


public class Auteur implements Comparable<Auteur>{
    private  String nom,prenom;
    private String nationalite;
    //private List<Ouvrage> louvrage = new ArrayList<>();
    //TODO remplacer par set
    private HashSet<Ouvrage> louvrage = new HashSet<>();

    public Auteur(String nom, String prenom, String nationalite) {
        this.nom = nom;
        this.prenom = prenom;
        this.nationalite = nationalite;

    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNationalite() {
        return nationalite;
    }

    public void setNationalite(String nationalite) {
        this.nationalite = nationalite;
    }

    public HashSet<Ouvrage> getLouvrage() {
        return louvrage;
    }

    public void setLouvrage(HashSet<Ouvrage> louvrage) {
        this.louvrage = louvrage;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Auteur auteur = (Auteur) o;
        return Objects.equals(nom, auteur.nom) && Objects.equals(prenom, auteur.prenom) && Objects.equals(nationalite, auteur.nationalite);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nom, prenom, nationalite);
    }

    @Override
    public String toString() {
        return "Auteur{" +
                "nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", nationalite='" + nationalite + '\'' +
                '}';
    }

    public void addOuvrage(Ouvrage o ){
        louvrage.add(o);
        o.getLauteurs().add(this);
    }

    public void remove(Ouvrage o){
        louvrage.remove(o);
        o.getLauteurs().remove(this);
    }

    public HashSet<Ouvrage> listerOuvrages(){

        return louvrage;
    }

    public HashSet<Ouvrage> listerOuvrages(TypeOuvrage to){
        HashSet<Ouvrage> lot = new HashSet<>();
        for(Ouvrage o : louvrage){
            if(o.getTo().equals(to)) lot.add(o);
        }
        return lot;
    }
    public HashSet<Livre> listerLivres(TypeLivre tl){
        HashSet<Livre>ll = new HashSet<>();
        for(Ouvrage o : louvrage){
            if(o.getTo().equals(LIVRE)) {
                Livre l = (Livre)o;
                if(l.getTl().equals(tl)) ll.add(l);
            }
        }
        return ll;
    }
    public HashSet<Ouvrage> listerOuvrages(String genre){
        HashSet<Ouvrage> lot = new HashSet<>();
        for(Ouvrage o : louvrage){
            if(o.getGenre().equals(genre)) lot.add(o);
        }
        return lot;
    }

    @Override
    public int compareTo(Auteur a) {
        return this.nom.compareTo(a.nom);
    }
}
