package bibliotheque.mvc.view;


import bibliotheque.metier.Auteur;
import bibliotheque.metier.DVD;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static bibliotheque.utilitaires.Utilitaire.*;

public class DVDViewConsole extends AbstractViewDVD {
    Scanner sc = new Scanner(System.in);


    @Override
    public void menu() {
        update(dvdController.getAll());
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
        DVD d;
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
                System.out.println("code : ");
                long code = sc.nextLong();
                System.out.println("durée totale : ");
                LocalTime dureeTotale = LocalTime.parse(sc.nextLine());
                System.out.println("nombre bonus : ");
                byte nbreBonus = sc.nextByte();
                d = new DVD(titre, ageMin, dateParution, prixLocation, langue, genre, code, dureeTotale, nbreBonus);
                break;
            } catch (Exception e) {
                System.out.println("une erreur est survenue : " + e.getMessage());
            }
        } while (true);
        dvdController.add(d);
    }

    public void retirer() {
        int ndvd = choixElt(ldvd) - 1;
        DVD d = ldvd.get(ndvd);
        boolean ok = dvdController.remove(d);
        if (ok) {
            affMsg("dvd effacé");
        } else {
            affMsg("dvd non effacé");
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
            System.out.println("code : ");
            long code = sc.nextLong();
            System.out.println("durée totale : ");
            LocalTime dureeTotale = LocalTime.parse(sc.nextLine());
            System.out.println("nombre bonus : ");
            byte nbreBonus = sc.nextByte();
            DVD rech = new DVD(titre, ageMin, dateParution, prixLocation, langue, genre, code, dureeTotale, nbreBonus);
            DVD d = dvdController.search(rech);
            if (d == null) {
                affMsg("dvd inconnu");
            } else {
                affMsg(d.toString());
            }
        } catch (Exception e) {
            System.out.println("erreur : " + e);
        }
    }

    public void modifier() {
        int choix = choixElt(ldvd);
        DVD d = ldvd.get(choix - 1);
        do {
            try {
                long code = d.getCode();
                LocalTime dureeTotale = d.getDureeTotale();
                byte nbreBonus = d.getNbreBonus();
                d.setCode(code);
                d.setDureeTotale(dureeTotale);
                d.setNbreBonus(nbreBonus);
                break;
            } catch (Exception e) {
                System.out.println("erreur : " + e);
            }
        } while (true);
        dvdController.update(d);
    }

    private void affMsg(String msg) {
        System.out.println(msg);
    }

    @Override
    public void affList(List ldvd) {
        affListe(ldvd);
    }
}
