package bibliotheque.mvc.controller;

import bibliotheque.metier.Lecteur;
import bibliotheque.mvc.model.DAOLecteur;
import bibliotheque.mvc.view.AbstractViewLecteur;

import java.util.List;

public class LecteurController {
    protected DAOLecteur model;
    protected AbstractViewLecteur view;

    public LecteurController(DAOLecteur model, AbstractViewLecteur view) {
        this.model = model;
        this.view = view;
        this.view.setController(this);
    }

    public List<Lecteur> getAll() {
        List<Lecteur> l = model.getAll();
        return l;
    }

    public Lecteur add(Lecteur lec) {
        Lecteur nle = model.add(lec);
        return nle;
    }

    public boolean remove(Lecteur lec) {
        return model.remove(lec);
    }

    public Lecteur update(Lecteur lec) {
        return model.update(lec);
    }

    public Lecteur search(Lecteur rech) {
        return model.read(rech);
    }
}
