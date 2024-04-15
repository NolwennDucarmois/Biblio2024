package bibliotheque.mvc.model;

import bibliotheque.metier.*;
import bibliotheque.mvc.observer.Subject;

import java.util.List;

public abstract class DAOExemplaire extends Subject {
    public abstract Exemplaire add(Exemplaire ex);

    public abstract boolean remove(Exemplaire ex);

    public abstract Exemplaire update(Exemplaire ex);

    public abstract Exemplaire read(Exemplaire rech);

    public abstract List<Exemplaire> getAll();

    public List<Exemplaire> getNotification() {
        return getAll();
    }
}
