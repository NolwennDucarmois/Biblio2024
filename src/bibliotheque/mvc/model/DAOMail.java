package bibliotheque.mvc.model;

import bibliotheque.metier.Mail;
import bibliotheque.mvc.observer.Subject;

import java.util.List;

public abstract class DAOMail extends Subject {
    public abstract Mail add(Mail m);

    public abstract boolean remove(Mail m);

    public abstract Mail update(Mail m);

    public abstract Mail read(Mail rech);

    public abstract List<Mail> getAll();

    public List<Mail> getNotification() {
        return getAll();
    }
}
