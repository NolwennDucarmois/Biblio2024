package bibliotheque.mvc.view;

import bibliotheque.metier.Auteur;
import bibliotheque.metier.Livre;
import bibliotheque.metier.TypeLivre;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static bibliotheque.utilitaires.Utilitaire.*;
import static bibliotheque.utilitaires.Utilitaire.modifyIfNotBlank;

public class LivreViewConsole extends AbstractViewLivre {
    Scanner sc = new Scanner(System.in);

    @Override
    public void menu() {
        update(livreController.getAll());
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
        Livre li;
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
                System.out.println("isbn : ");
                String isbn = sc.nextLine();
                System.out.println("nombre de pages : ");
                int nbrePages = sc.nextInt();
                System.out.println("type de livre : ");
                TypeLivre tl = TypeLivre.valueOf(sc.nextLine());
                System.out.println("résumé : ");
                String resume = sc.nextLine();
                li = new Livre(titre, ageMin, dateParution, prixLocation, langue, genre, isbn, nbrePages, tl, resume);
                break;
            } catch (Exception e) {
                System.out.println("une erreur est survenue : " + e.getMessage());
            }
        } while (true);
        livreController.add(li);
    }

    public void retirer() {
        int nl = choixElt(li) - 1;
        Livre i = li.get(nl);
        boolean ok = livreController.remove(i);
        if (ok) {
            affMsg("livre effacé");
        } else {
            affMsg("livre non effacé");
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
            System.out.println("isbn : ");
            String isbn = sc.nextLine();
            System.out.println("nombre de pages : ");
            int nbrePages = sc.nextInt();
            System.out.println("type de livre : ");
            TypeLivre tl = TypeLivre.valueOf(sc.nextLine());
            System.out.println("résumé : ");
            String resume = sc.nextLine();
            Livre rech = new Livre(titre, ageMin, dateParution, prixLocation, langue, genre, isbn, nbrePages, tl, resume);
            Livre i = livreController.search(rech);
            if (i == null) {
                affMsg("livre inconnu");
            } else {
                affMsg(i.toString());
            }
        } catch (Exception e) {
            System.out.println("erreur : " + e);
        }
    }

    public void modifier() {
        int choix = choixElt(li);
        Livre i = li.get(choix - 1);
        do {
            try {
                String isbn = modifyIfNotBlank("isbn", i.getIsbn());
                int nbrePages = i.getNbrePages();
                TypeLivre tl = i.getTl();
                String resume = modifyIfNotBlank("resumé", i.getResume());
                i.setIsbn(isbn);
                i.setNbrePages(nbrePages);
                i.setTl(tl);
                i.setResume(resume);
                break;
            } catch (Exception e) {
                System.out.println("erreur :" + e);
            }
        } while (true);
        livreController.update(i);
    }

    private void affMsg(String msg) {
        System.out.println(msg);
    }

    @Override
    public void affList(List li) {
        affListe(li);
    }
}
