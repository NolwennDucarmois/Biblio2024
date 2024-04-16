package bibliotheque.mvc.model;

import bibliotheque.metier.DVD;
import bibliotheque.mvc.observer.Subject;

import java.util.List;

public abstract class DAODVD extends Subject {
    public abstract DVD add(DVD d);

    public abstract boolean remove(DVD d);

    public abstract DVD update(DVD d);

    public abstract DVD read(DVD rech);

    public abstract List<DVD> getAll();

    public List<DVD> getNotification() {
        return getAll();
    }
}
