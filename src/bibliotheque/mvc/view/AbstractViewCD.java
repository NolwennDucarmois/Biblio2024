package bibliotheque.mvc.view;

import bibliotheque.metier.CD;
import bibliotheque.mvc.controller.CDController;
import bibliotheque.mvc.observer.Observer;

import java.util.List;

public abstract class AbstractViewCD implements Observer {
    protected CDController cdController;
    protected List<CD> lcd;

    public void setController(CDController cdController) {
        this.cdController = cdController;
    }

    public abstract void menu();

    public abstract void affList(List lcd);

    public List<CD> getAll() {
        return lcd;
    }

    @Override
    public void update(List lcd) {
        this.lcd = lcd;
        affList(lcd);
    }
}
