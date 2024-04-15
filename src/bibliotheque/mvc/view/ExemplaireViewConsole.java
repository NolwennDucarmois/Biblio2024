package bibliotheque.mvc.view;

import bibliotheque.metier.Exemplaire;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static bibliotheque.utilitaires.Utilitaire.*;

public class ExemplaireViewConsole extends AbstractViewExemplaire {
    Scanner sc = new Scanner(System.in);

    @Override
    public void menu() {
        update(exemplaireController.getAll());
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
        Exemplaire ex;
        do {
            try {
                System.out.println("matricule ");
                String matricule = sc.nextLine();
                System.out.println("descriptionEtat ");
                String descriptionEtat = sc.nextLine();
                ex = new Exemplaire(matricule, descriptionEtat);
                break;
            } catch (Exception e) {
                System.out.println("une erreur est survenue : " + e.getMessage());
            }
        } while (true);
        exemplaireController.add(ex);
    }

    private void retirer() {
        int n = choixElt(lex) - 1;
        Exemplaire e = lex.get(n);
        boolean ok = exemplaireController.remove(e);
        if (ok) {
            affMsg("exemplaire effacé");
        } else {
            affMsg("exemplaire non effacé");
        }
    }

    private void rechercher() {
        try {
            System.out.println("matricule ");
            String matricule = sc.nextLine();
            System.out.println("descriptionEtat ");
            String descriptionEtat = sc.nextLine();
            Exemplaire rech = new Exemplaire(matricule, descriptionEtat);
            Exemplaire ex = exemplaireController.search(rech);
            if (ex == null) affMsg("exemplaire inconnu");
            else {
                affMsg(ex.toString());
            }
        } catch (Exception e) {
            System.out.println("erreur : " + e);
        }
    }

    private void modifier() {
        int choix = choixElt(lex);
        Exemplaire ex = lex.get(choix - 1);
        do {
            try {
                String matricule = modifyIfNotBlank("matricule", ex.getMatricule());
                String descriptionEtat = modifyIfNotBlank("descriptionEtat", ex.getDescriptionEtat());
                ex.setMatricule(matricule);
                ex.setDescriptionEtat(descriptionEtat);
                break;
            } catch (Exception e) {
                System.out.println("erreur : " + e);
            }
        } while (true);
        exemplaireController.update(ex);
    }

    private void affMsg(String msg) {
        System.out.println(msg);
    }

    @Override
    public void affList(List list) {
        affListe(list);
    }

}
