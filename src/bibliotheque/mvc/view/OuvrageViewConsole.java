package bibliotheque.mvc.view;

import bibliotheque.metier.Ouvrage;
import bibliotheque.metier.TypeOuvrage;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static bibliotheque.utilitaires.Utilitaire.*;

public class OuvrageViewConsole extends AbstractViewOuvrage {
    Scanner sc = new Scanner(System.in);

    @Override
    public void menu() {
        update(ouvrageController.getAll());
        List options = Arrays.asList("ajouter", "retirer", "rechercher", "modifier", "fin");
        do {
            int ch = choixListe(options);

            switch (ch) {
                case 1:
                    ajouter();
                    break;
                case 2:
                    retirer();
                    break;
                case 3:
                    rechercher();
                    break;
                case 4:
                    modifier();
                    break;
                case 5:
                    return;
            }
        } while (true);
    }

    public void ajouter() {
        Ouvrage o;
        do {
            try {
                System.out.println("titre : ");
                String titre = sc.nextLine();
                System.out.println("age minimum : ");
                int ageMin = sc.nextInt();
                System.out.println("date de parution : ");
                String[] jma = sc.nextLine().split(" ");
                int j = Integer.parseInt(jma[0]);
                int m = Integer.parseInt(jma[1]);
                int a = Integer.parseInt(jma[2]);
                LocalDate dateParution = LocalDate.of(a, m, j);
                System.out.println("prix de la location : ");
                double prixLocation = sc.nextDouble();
                System.out.println("langue : ");
                String langue = sc.nextLine();
                System.out.println("genre : ");
                String genre = sc.nextLine();
                //o = new Ouvrage(titre, ageMin, dateParution, prixLocation, langue, genre);
                break;
            } catch (Exception e) {
                System.out.println("une erreur est survenue : " + e.getMessage());
            }
        } while (true);
        //ouvrageController.add(o);
    }

    public void retirer() {
        int nl = choixElt(louv) - 1;
        Ouvrage o = louv.get(nl);
        boolean ok = ouvrageController.remove(o);
        if (ok) {
            affMsg("ouvrage effacé");
        } else {
            affMsg("ouvrage non effacé");
        }
    }

    public void rechercher() {
        try {
            System.out.println("titre : ");
            String titre = sc.nextLine();
            System.out.println("age minimum : ");
            int ageMin = sc.nextInt();
            System.out.println("date de parution : ");
            String[] jma = sc.nextLine().split(" ");
            int j = Integer.parseInt(jma[0]);
            int m = Integer.parseInt(jma[1]);
            int a = Integer.parseInt(jma[2]);
            LocalDate dateParution = LocalDate.of(a, m, j);
            System.out.println("prix de la location : ");
            double prixLocation = sc.nextDouble();
            System.out.println("langue : ");
            String langue = sc.nextLine();
            System.out.println("genre : ");
            String genre = sc.nextLine();
            /*Ouvrage rech = new Ouvrage(titre, ageMin, dateParution, prixLocation, langue, genre);
            Ouvrage o = ouvrageController.search(rech);

            if(o==null){
                affMsg("ouvrage inconnu");
            }else{
                affMsg(o.toString());
            }*/
        } catch (Exception e) {
            System.out.println("erreur : " + e);
        }
    }

    public void modifier() {
        int choix = choixElt(louv);
        Ouvrage o = louv.get(choix - 1);
        do {
            try {
                String titre = modifyIfNotBlank("titre", o.getTitre());
                int ageMin = o.getAgeMin();
                LocalDate dateParution = o.getDateParution();
                TypeOuvrage to = o.getTo();
                double prixLocation = o.getPrixLocation();
                String langue = modifyIfNotBlank("langue", o.getLangue());
                String genre = modifyIfNotBlank("genre", o.getGenre());
                o.setTitre(titre);
                o.setAgeMin(ageMin);
                o.setDateParution(dateParution);
                o.setTo(to);
                o.setPrixLocation(prixLocation);
                o.setLangue(langue);
                o.setGenre(genre);
                break;
            } catch (Exception e) {
                System.out.println("erreur : " + e);
            }
        } while (true);
        ouvrageController.update(o);
    }

    private void affMsg(String msg) {
        System.out.println(msg);
    }

    @Override
    public void affList(List louv) {
        affListe(louv);
    }
}
