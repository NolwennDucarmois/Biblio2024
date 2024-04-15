package bibliotheque.mvc.controller;

import bibliotheque.metier.Livre;
import bibliotheque.mvc.model.DAOLivre;
import bibliotheque.mvc.view.AbstractViewLivre;

import java.util.List;

public class LivreController {
    protected DAOLivre model;
    protected AbstractViewLivre view;

    public LivreController(DAOLivre model, AbstractViewLivre view) {
        this.model = model;
        this.view = view;
        this.view.setController(this);
    }

    public List<Livre> getAll() {
        List<Livre> l = model.getAll();
        return l;
    }

    public Livre add(Livre li) {
        Livre nli = model.add(li);
        return nli;
    }

    public boolean remove(Livre li) {
        return model.remove(li);
    }

    public Livre update(Livre li) {
        return model.update(li);
    }

    public Livre search(Livre rech) {
        return model.read(rech);
    }
}
