package bibliotheque.mvc.view;

import bibliotheque.metier.Rayon;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static bibliotheque.utilitaires.Utilitaire.*;

public class RayonViewConsole extends AbstractViewRayon {
    Scanner sc = new Scanner(System.in);

    @Override
    public void menu() {
        update(rayonController.getAll());
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
        Rayon r;
        do {
            try {
                System.out.println("codeRayon : ");
                String codeRayon = sc.nextLine();
                System.out.println("genre : ");
                String genre = sc.nextLine();
                r = new Rayon(codeRayon, genre);
                break;
            } catch (Exception e) {
                System.out.println("une erreur est survenue : " + e.getMessage());
            }
        } while (true);
        rayonController.add(r);
    }

    public void retirer() {
        int nr = choixElt(lr) - 1;
        Rayon r = lr.get(nr);
        boolean ok = rayonController.remove(r);
        if (ok) {
            affMsg("rayon effacé");
        } else {
            affMsg("rayon non effacé");
        }
    }

    public void rechercher() {
        try {
            System.out.println("codeRayon : ");
            String codeRayon = sc.nextLine();
            System.out.println("genre : ");
            String genre = sc.nextLine();
            Rayon rech = new Rayon(codeRayon, genre);
            Rayon r = rayonController.search(rech);
            if (r == null) {
                affMsg("rayon inconnu");
            } else {
                affMsg(r.toString());
            }
        } catch (Exception e) {
            System.out.println("erreur : " + e);
        }
    }

    public void modifier() {
        int choix = choixElt(lr);
        Rayon r = lr.get(choix - 1);
        do {
            try {
                String codeRayon = modifyIfNotBlank("code rayon", r.getCodeRayon());
                String genre = modifyIfNotBlank("genre", r.getGenre());
                r.setCodeRayon(codeRayon);
                r.setGenre(genre);
                break;
            } catch (Exception e) {
                System.out.println("erreur :" + e);
            }
        } while (true);
        rayonController.update(r);
    }

    private void affMsg(String msg) {
        System.out.println(msg);
    }

    @Override
    public void affList(List lr) {
        affListe(lr);
    }
}
