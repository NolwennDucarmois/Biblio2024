package bibliotheque.metier;

import java.util.ArrayList;
import java.util.List;

public class Rayon {
    private String codeRayon;
    private String genre;
    private List<Exemplaire> listExemplaire = new ArrayList<>();
    public Rayon(){

    }
    public Rayon(String codeRayon, String genre){
        this.codeRayon=codeRayon;
        this.genre=genre;
    }

    public String getCodeRayon() {
        return codeRayon;
    }

    public void setCodeRayon(String codeRayon) {
        this.codeRayon = codeRayon;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public List<Exemplaire> getListExemplaire() {
        return listExemplaire;
    }

    public void setListExemplaire(List<Exemplaire> listExemplaire) {
        this.listExemplaire = listExemplaire;
    }

    public void listerExamplaires(){

    }

    @Override
    public String toString() {
        return "Rayon{" +
                "codeRayon='" + codeRayon + '\'' +
                ", genre='" + genre + '\'' +
                ", listExemplaire=" + listExemplaire +
                '}';
    }
}
