package bibliotheque.mvc;

import bibliotheque.metier.Auteur;
import bibliotheque.mvc.controller.*;
import bibliotheque.mvc.model.*;
import bibliotheque.mvc.view.*;
import bibliotheque.utilitaires.Utilitaire;

import java.util.Arrays;
import java.util.List;

public class GestionMVC {

    private DAOAuteur am;
    private AbstractViewAuteur av;
    private AuteurController ac;

    private DAOCD cdm;
    private AbstractViewCD cdv;
    private CDController cdc;

    private DAODVD dvdm;
    private AbstractViewDVD dvdv;
    private DVDController dvdc;

    private DAOExemplaire exm;
    private AbstractViewExemplaire exv;
    private ExemplaireController exc;

    private DAOLecteur lem;
    private AbstractViewLecteur lev;
    private LecteurController lec;

    private DAOLivre lim;
    private AbstractViewLivre liv;
    private LivreController lic;

    private DAOMail mm;
    private AbstractViewMail mv;
    private MailController mc;

    private DAORayon rm;
    private AbstractViewRayon rv;
    private RayonController rc;

    public void gestion() {

        am = new AuteurModel();
        av = new AuteurViewConsole();
        ac = new AuteurController(am, av);//création et injection de dépendance
        am.addObserver(av);

        cdm = new CDModel();
        cdv = new CDViewConsole();
        cdc = new CDController(cdm, cdv);
        cdm.addObserver(cdv);

        dvdm = new DVDModel();
        dvdv = new DVDViewConsole();
        dvdc = new DVDController(dvdm, dvdv);
        dvdm.addObserver(dvdv);

        exm = new ExemplaireModel();
        exv = new ExemplaireViewConsole();
        exc = new ExemplaireController(exm, exv);
        exm.addObserver(exv);

        lem = new LecteurModel();
        lev = new LecteurViewConsole();
        lec = new LecteurController(lem, lev);
        lem.addObserver(lev);

        lim = new LivreModel();
        liv = new LivreViewConsole();
        lic = new LivreController(lim, liv);
        lim.addObserver(liv);

        mm = new MailModel();
        mv = new MailViewConsole();
        mc = new MailController(mm, mv);
        mm.addObserver(mv);

        rm = new RayonModel();
        rv = new RayonViewConsole();
        rc = new RayonController(rm, rv);
        rm.addObserver(rv);

        try {
            populate();
        } catch (Exception e) {
            System.out.println("erreur lors du populate : " + e);
            System.exit(1);
        }
        List<String> loptions = Arrays.asList("auteurs", "cd", "dvd", "exemplaires", "lecteurs", "livres", "mails", "rayons", "fin");
        do {
            int ch = Utilitaire.choixListe(loptions);
            switch (ch) {
                case 1:
                    av.menu();
                    break;
                case 2:
                    cdv.menu();
                    break;
                case 3:
                    dvdv.menu();
                    break;
                case 4:
                    exv.menu();
                    break;
                case 5:
                    lev.menu();
                    break;
                case 6:
                    liv.menu();
                    break;
                case 7:
                    mv.menu();
                    break;
                case 8:
                    rv.menu();
                    break;
                case 9:
                    System.exit(0);
            }
        } while (true);
    }

    public void populate() {

        Auteur a = new Auteur("Verne", "Jules", "France");
        am.getAll().add(a);
        a = new Auteur("Spielberg", "Steven", "USA");
        am.getAll().add(a);
        a = new Auteur("Kubrick", "Stanley", "GB");
        am.getAll().add(a);
    }

    public static void main(String[] args) {
        GestionMVC gb = new GestionMVC();
        gb.gestion();
    }
}
