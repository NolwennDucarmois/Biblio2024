package bibliotheque.mvc.view;

import bibliotheque.metier.Ouvrage;
import bibliotheque.mvc.controller.OuvrageController;
import bibliotheque.mvc.observer.Observer;

import java.util.List;

public abstract class AbstractViewOuvrage implements Observer {
    protected OuvrageController ouvrageController;
    protected List<Ouvrage> louv;

    public void setController(OuvrageController ouvrageController) {
        this.ouvrageController = ouvrageController;
    }

    public abstract void menu();

    public abstract void affList(List louv);

    public List<Ouvrage> getAll() {
        return louv;
    }

    @Override
    public void update(List louv) {
        this.louv = louv;
        affList(louv);
    }
}
