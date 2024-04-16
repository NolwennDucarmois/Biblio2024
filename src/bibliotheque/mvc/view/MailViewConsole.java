package bibliotheque.mvc.view;

import bibliotheque.metier.Auteur;
import bibliotheque.metier.Mail;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static bibliotheque.utilitaires.Utilitaire.*;

public class MailViewConsole extends AbstractViewMail {

    Scanner sc = new Scanner(System.in);

    @Override
    public void menu() {
        update(mailController.getAll());
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
        Mail m;
        do {
            try {
                System.out.println("objet : ");
                String objet = sc.nextLine();
                System.out.println("message : ");
                String message = sc.nextLine();
                System.out.println("date d'envoi : ");
                String dateEnvoi = sc.nextLine();
                m = new Mail(objet, message, dateEnvoi);
                break;
            } catch (Exception e) {
                System.out.println("une erreur est survenue : " + e.getMessage());
            }

        } while (true);
        mailController.add(m);
    }

    public void retirer() {
        int nl = choixElt(lmail) - 1;
        Mail m = lmail.get(nl);
        boolean ok = mailController.remove(m);
        if (ok) {
            affMsg("mail effacé");
        } else {
            affMsg("mail non effacé");
        }
    }

    public void rechercher() {
        try {
            System.out.println("objet : ");
            String objet = sc.nextLine();
            System.out.println("message : ");
            String message = sc.nextLine();
            System.out.println("date d'envoi : ");
            String dateEnvoi = sc.nextLine();
            Mail rech = new Mail(objet, message, dateEnvoi);
            Mail m = mailController.search(rech);
            if (m == null) {
                affMsg("mail inconnu");
            } else {
                affMsg(m.toString());
            }
        } catch (Exception e) {
            System.out.println("erreur : " + e);
        }
    }

    public void modifier() {
        int choix = choixElt(lmail);
        Mail m = lmail.get(choix - 1);
        do {
            try {
                String objet = modifyIfNotBlank("objet", m.getObjet());
                String message = modifyIfNotBlank("message", m.getMessage());
                String dateEnvoi = modifyIfNotBlank("dateEnvoi", m.getDateEnvoi());
                m.setObjet(objet);
                m.setMessage(message);
                m.setDateEnvoi(dateEnvoi);
                break;
            } catch (Exception e) {
                System.out.println("erreur : " + e);
            }
        } while (true);
        mailController.update(m);
    }

    private void affMsg(String msg) {
        System.out.println(msg);
    }

    @Override
    public void affList(List lmail) {
        affListe(lmail);
    }
}
