package bibliotheque.mvc.view;

import bibliotheque.metier.Exemplaire;
import bibliotheque.mvc.controller.ExemplaireController;
import bibliotheque.mvc.observer.Observer;

import java.util.List;

public abstract class AbstractViewExemplaire implements Observer {
    protected ExemplaireController exemplaireController;
    protected List<Exemplaire> lex;

    public void setController(ExemplaireController exemplaireController) {
        this.exemplaireController = exemplaireController;
    }

    public abstract void menu();

    public abstract void affList(List lex);

    public List<Exemplaire> getAll() {
        return lex;
    }

    @Override
    public void update(List lex) {
        this.lex = lex;
        affList(lex);
    }
}
