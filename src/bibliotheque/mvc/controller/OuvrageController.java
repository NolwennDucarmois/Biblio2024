package bibliotheque.mvc.controller;

import bibliotheque.metier.Ouvrage;
import bibliotheque.mvc.model.DAOOuvrage;
import bibliotheque.mvc.view.AbstractViewOuvrage;

import java.util.List;

public class OuvrageController {
    protected DAOOuvrage model;
    protected AbstractViewOuvrage view;

    public OuvrageController(DAOOuvrage model, AbstractViewOuvrage view) {
        this.model = model;
        this.view = view;
        this.view.setController(this);
    }

    public List<Ouvrage> getAll() {
        List<Ouvrage> l = model.getAll();
        return l;
    }

    public Ouvrage add(Ouvrage ouv) {
        Ouvrage nouv = model.add(ouv);
        return nouv;
    }

    public boolean remove(Ouvrage ouv) {
        return model.remove(ouv);
    }

    public Ouvrage update(Ouvrage ouv) {
        return model.update(ouv);
    }

    public Ouvrage search(Ouvrage rech) {
        return model.read(rech);
    }
}
