package bibliotheque.mvc.view;

import bibliotheque.metier.CD;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static bibliotheque.utilitaires.Utilitaire.*;

public class CDViewConsole extends AbstractViewCD {
    Scanner sc = new Scanner(System.in);

    @Override
    public void menu() {
        update(cdController.getAll());
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
        CD c;
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
                System.out.println("nbrePlages : ");
                byte nbrePlages = sc.nextByte();
                System.out.println("durée totale : ");
                LocalTime dureeTotale = LocalTime.parse(sc.nextLine());
                c = new CD(titre, ageMin, dateParution, prixLocation, langue, genre, code, nbrePlages, dureeTotale);
                break;
            } catch (Exception e) {
                System.out.println("une erreur est survenue : " + e.getMessage());
            }
        } while (true);
        cdController.add(c);
    }

    public void retirer() {
        int nl = choixElt(lcd) - 1;
        CD c = lcd.get(nl);
        boolean ok = cdController.remove(c);
        if (ok) {
            affMsg("cd effacé");
        } else {
            affMsg("cd non effacé");
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
            System.out.println("nbrePlages : ");
            byte nbrePlages = sc.nextByte();
            System.out.println("durée totale : ");
            LocalTime dureeTotale = LocalTime.parse(sc.nextLine());
            CD rech = new CD(titre, ageMin, dateParution, prixLocation, langue, genre, code, nbrePlages, dureeTotale);
            CD c = cdController.search(rech);
            if (c == null) {
                affMsg("cd inconnu");
            } else {
                affMsg(c.toString());
            }
        } catch (Exception e) {
            System.out.println("erreur : " + e);
        }
    }

    public void modifier() {
        int choix = choixElt(lcd);
        CD c = lcd.get(choix - 1);
        do {
            try {
                long code = c.getCode();
                byte nbrePlages = c.getNbrePlages();
                LocalTime dureeTotale = c.getDureeTotale();
                c.setCode(code);
                c.setNbrePlages(nbrePlages);
                c.setDureeTotale(dureeTotale);
                break;
            } catch (Exception e) {
                System.out.println("erreur : " + e);
            }
        } while (true);
        cdController.update(c);
    }

    @Override
    public void affList(List lcd) {
        affListe(lcd);
    }

    private void affMsg(String msg) {
        System.out.println(msg);
    }
}
