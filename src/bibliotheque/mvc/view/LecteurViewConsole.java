package bibliotheque.mvc.view;

import bibliotheque.metier.Lecteur;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static bibliotheque.utilitaires.Utilitaire.*;
import static bibliotheque.utilitaires.Utilitaire.modifyIfNotBlank;

public class LecteurViewConsole extends AbstractViewLecteur {
    Scanner sc = new Scanner(System.in);

    @Override
    public void menu() {
        update(lecteurController.getAll());
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


    private void ajouter() {
        Lecteur le;
        do {
            try {
                System.out.println("numLecteur : ");
                int numlecteur = sc.nextInt();
                System.out.println("nom : ");
                String nom = sc.nextLine();
                System.out.println("prénom : ");
                String prenom = sc.nextLine();
                System.out.println("date : ");
                String[] jma = sc.nextLine().split(" ");
                int j = Integer.parseInt(jma[0]);
                int m = Integer.parseInt(jma[1]);
                int a = Integer.parseInt(jma[2]);
                LocalDate dn = LocalDate.of(a, m, j);
                System.out.println("adresse : ");
                String adresse = sc.nextLine();
                System.out.println("mail : ");
                String mail = sc.nextLine();
                System.out.println("téléphone : ");
                String tel = sc.nextLine();
                le = new Lecteur(numlecteur, nom, prenom, dn, adresse, mail, tel);
                break;
            } catch (Exception e) {
                System.out.println("une erreur est survenue : " + e.getMessage());
            }
        } while (true);
        lecteurController.add(le);
    }

    private void retirer() {
        int nl = choixElt(le) - 1;
        Lecteur l = le.get(nl);
        boolean ok = lecteurController.remove(l);
        if (ok) {
            affMsg("lecteur effacé");
        } else {
            affMsg("lecteur non effacé");
        }
    }

    private void rechercher() {
        try {
            System.out.println("numLecteur : ");
            int numlecteur = sc.nextInt();
            System.out.println("nom : ");
            String nom = sc.nextLine();
            System.out.println("prénom : ");
            String prenom = sc.nextLine();
            System.out.println("date : ");
            String[] jma = sc.nextLine().split(" ");
            int j = Integer.parseInt(jma[0]);
            int m = Integer.parseInt(jma[1]);
            int a = Integer.parseInt(jma[2]);
            LocalDate dn = LocalDate.of(a, m, j);
            System.out.println("adresse : ");
            String adresse = sc.nextLine();
            System.out.println("mail : ");
            String mail = sc.nextLine();
            System.out.println("téléphone : ");
            String tel = sc.nextLine();
            Lecteur rech = new Lecteur(numlecteur, nom, prenom, dn, adresse, mail, tel);
            Lecteur l = lecteurController.search(rech);
            if (l == null) {
                affMsg("lecteur inconnu");
            } else {
                affMsg(l.toString());
            }
        } catch (Exception e) {
            System.out.println("erreur : " + e);
        }
    }

    private void modifier() {
        int choix = choixElt(le);
        Lecteur l = le.get(choix - 1);
        do {
            try {
                int numLecteur = l.getNumlecteur();
                String nom = modifyIfNotBlank("nom", l.getNom());
                String prenom = modifyIfNotBlank("prénom", l.getPrenom());
                LocalDate dn = l.getDn();
                String adresse = modifyIfNotBlank("adresse", l.getAdresse());
                String mail = modifyIfNotBlank("mail", l.getMail());
                String tel = modifyIfNotBlank("téléphone", l.getTel());
                l.setNumlecteur(numLecteur);
                l.setNom(nom);
                l.setPrenom(prenom);
                l.setDn(dn);
                l.setAdresse(adresse);
                l.setMail(mail);
                l.setTel(tel);
                break;
            } catch (Exception e) {
                System.out.println("erreur :" + e);
            }
        } while (true);
        lecteurController.update(l);
    }

    private void affMsg(String msg) {
        System.out.println(msg);
    }

    @Override
    public void affList(List le) {
        affList(le);
    }
}
