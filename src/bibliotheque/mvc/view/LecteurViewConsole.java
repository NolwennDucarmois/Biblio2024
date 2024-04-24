package bibliotheque.mvc.view;

import bibliotheque.metier.Lecteur;
import bibliotheque.mvc.GestionMVC;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import static bibliotheque.utilitaires.Utilitaire.*;


public class LecteurViewConsole extends AbstractView<Lecteur> {
    Scanner sc = new Scanner(System.in);


    @Override
    public void menu() {
        update(controller.getAll());
        List options = Arrays.asList("ajouter", "retirer", "rechercher", "modifier", "ajout liste", "fin");
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
                    ajout_liste();
                case 6:
                    return;
            }
        } while (true);
    }

    @Override
    public void affList(List la) {
        affListe(la);
    }

    private void retirer() {
        int nl = choixElt(la) - 1;
        Lecteur l = la.get(nl);
        boolean ok = controller.remove(l);
        if (ok) affMsg("lecteur effacé");
        else affMsg("lecteur non effacé");
    }

    private void affMsg(String msg) {
        System.out.println(msg);
    }


    public void rechercher() {
        try {
            System.out.println("numéro de lecteur :");
            int id = lireInt();
            Lecteur rech = new Lecteur(id, "", "", null, "", "", "");
            Lecteur l = controller.search(rech);
            if (l == null) affMsg("lecteur inconnu");
            else {
                affMsg(l.toString());
            }
        } catch (Exception e) {
            System.out.println("erreur : " + e);
        }

    }


    public void modifier() {
        int choix = choixElt(la);
        Lecteur l = la.get(choix - 1);
        do {
            try {
                String nom = modifyIfNotBlank("nom", l.getNom());
                String prenom = modifyIfNotBlank("prénom", l.getPrenom());
                String mail = modifyIfNotBlank("nationalité", l.getMail());
                l.setNom(nom);
                l.setPrenom(prenom);
                l.setMail(mail);
                //TODO gérer autres valeurs
                break;
            } catch (Exception e) {
                System.out.println("erreur :" + e);
            }
        } while (true);
        controller.update(l);
    }


    public void ajouter() {
        Lecteur l;
        do {
            try {
                System.out.println("nom ");
                String nom = sc.nextLine();
                System.out.println("prénom ");
                String prenom = sc.nextLine();
                System.out.println("date de naissance :");
                LocalDate dn = lecDate();
                System.out.println("mail :");
                String mail = sc.nextLine();
                System.out.println("adresse :");
                String adr = sc.nextLine();
                System.out.println("tel :");
                String tel = sc.nextLine();
                l = new Lecteur(nom, prenom, dn, adr, mail, tel);
                break;
            } catch (Exception e) {
                System.out.println("une erreur est survenue : " + e.getMessage());
            }
        } while (true);
        l = controller.add(l);
        affMsg("création du lecteur : " + l);
    }

    public void ajout_liste() {
        String chemin_fichier = "C:/Users/Nolwenn/Documents/Condorcet/2 I/Q2/POO 2/nouveaux_lecteurs.txt";
        try (BufferedReader in = new BufferedReader(new FileReader(chemin_fichier))) {
            String val;
            while ((val = in.readLine()) != null) {
                String[] infos = val.split(" ");
                String nom = infos[0];
                String prenom = infos[1];
                LocalDate dn = LocalDate.parse(infos[2]);
                String adresse = infos[3];
                String mail = infos[4];
                String tel = infos[5];
                Lecteur lecteur = new Lecteur(nom, prenom, dn, adresse, mail, tel);
                controller.add(lecteur);
            }
        } catch (IOException e) {
            System.out.println("Accès impossible : " + e.getMessage());
        }
    }
}
