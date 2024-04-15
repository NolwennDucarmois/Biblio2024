package bibliotheque.mvc.model;

import bibliotheque.metier.Lecteur;
import bibliotheque.mvc.observer.Subject;

import java.util.List;

public abstract class DAOLecteur extends Subject {
    public abstract Lecteur add(Lecteur lec);

    public abstract boolean remove(Lecteur lec);

    public abstract Lecteur update(Lecteur lec);

    public abstract Lecteur read(Lecteur rech);

    public abstract List<Lecteur> getAll();

    public List<Lecteur> getNotification() {
        return getAll();
    }
}
