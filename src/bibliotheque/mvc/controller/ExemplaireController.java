package bibliotheque.mvc.controller;

import bibliotheque.metier.Exemplaire;
import bibliotheque.mvc.model.DAOExemplaire;
import bibliotheque.mvc.view.AbstractViewExemplaire;

import java.util.List;

public class ExemplaireController {

    protected DAOExemplaire model;
    protected AbstractViewExemplaire view;

    public ExemplaireController(DAOExemplaire model, AbstractViewExemplaire view) {
        this.model = model;
        this.view = view;
        this.view.setController(this);
    }

    public List<Exemplaire> getAll() {
        List<Exemplaire> l = model.getAll();
        return l;
    }

    public Exemplaire add(Exemplaire ex) {
        Exemplaire nex = model.add(ex);
        return nex;
    }

    public boolean remove(Exemplaire ex) {
        return model.remove(ex);
    }

    public Exemplaire update(Exemplaire ex) {
        return model.update(ex);
    }

    public Exemplaire search(Exemplaire rech) {
        return model.read(rech);
    }
}
