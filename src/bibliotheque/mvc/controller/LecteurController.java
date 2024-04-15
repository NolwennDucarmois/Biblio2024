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

    public boolean remove(Lecteur le) {
        return model.remove(le);
    }

    public Lecteur update(Lecteur le) {
        return model.update(le);
    }

    public Lecteur search(Lecteur rech) {
        return model.read(rech);
    }
}
