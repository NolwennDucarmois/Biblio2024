package bibliotheque.mvc.view;

import bibliotheque.metier.DVD;
import bibliotheque.mvc.controller.DVDController;
import bibliotheque.mvc.observer.Observer;

import java.util.List;

public abstract class AbstractViewDVD implements Observer {
    protected DVDController dvdController;
    protected List<DVD> ldvd;

    public void setController(DVDController dvdController) {
        this.dvdController = dvdController;
    }

    public abstract void menu();

    public abstract void affList(List ldvd);

    public List<DVD> getAll() {
        return ldvd;
    }

    @Override
    public void update(List ldvd) {
        this.ldvd = ldvd;
        affList(ldvd);
    }
}
