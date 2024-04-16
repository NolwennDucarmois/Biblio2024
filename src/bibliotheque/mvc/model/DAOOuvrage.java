package bibliotheque.mvc.model;

import bibliotheque.metier.Ouvrage;
import bibliotheque.mvc.observer.Subject;

import java.util.List;

public abstract class DAOOuvrage extends Subject {
    public abstract Ouvrage add(Ouvrage ouv);

    public abstract boolean remove(Ouvrage ouv);

    public abstract Ouvrage update(Ouvrage ouv);

    public abstract Ouvrage read(Ouvrage rech);

    public abstract List<Ouvrage> getAll();

    public List<Ouvrage> getNotification() {
        return getAll();
    }
}
