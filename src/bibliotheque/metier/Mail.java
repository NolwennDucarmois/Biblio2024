package bibliotheque.metier;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Mail {
    private String objet;
    private String message;
    private String dateEnvoi;

    public Mail(String objet, String message, String dateEnvoi) {
        this.objet = objet;
        this.message = message;
        this.dateEnvoi = dateEnvoi;
    }

    public String getObjet() {
        return objet;
    }

    public void setObjet(String objet) {
        this.objet = objet;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDateEnvoi() {
        return dateEnvoi;
    }

    public void setDateEnvoi(String dateEnvoi) {
        this.dateEnvoi = dateEnvoi;
    }

    @Override
    public String toString() {
        return "Mail{" +
                "objet='" + objet + '\'' +
                ", message='" + message + '\'' +
                ", dateEnvoi='" + dateEnvoi + '\'' +
                '}';
    }

    public void envoi(Lecteur l) {
        File fichier;
        String nom = l.getMail();
        String contenu = objet + "\n" + message;
        fichier = new File("C:/Users/Nolwenn/Documents/Condorcet/2 I/Q2/POO 2/" + nom + ".txt");
        try (FileWriter out = new FileWriter(fichier)) {
            PrintWriter p = new PrintWriter(out);
            p.println(contenu + "\n");
            System.out.println("Mail envoyé à : "+nom);
        } catch (IOException e) {
            System.out.println("Problème d'accès : " + e.getMessage());
        }
    }
}
