package bibliotheque.mvc.model;

import bibliotheque.metier.Livre;
import bibliotheque.mvc.observer.Subject;

import java.util.List;

public abstract class DAOLivre extends Subject {
    public abstract Livre add(Livre li);

    public abstract boolean remove(Livre li);

    public abstract Livre update(Livre li);

    public abstract Livre read(Livre rech);

    public abstract List<Livre> getAll();

    public List<Livre> getNotification() {
        return getAll();
    }
}
