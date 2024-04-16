package bibliotheque.mvc.model;

import bibliotheque.metier.Mail;

import java.util.ArrayList;
import java.util.List;

public class MailModel extends DAOMail {
    private List<Mail> liste = new ArrayList<>();

    @Override
    public Mail add(Mail m) {
        boolean present = liste.contains(m);
        if (!present) {
            liste.add(m);
            notifyObservers();
            return m;
        } else {
            return null;
        }
    }

    @Override
    public boolean remove(Mail m) {
        boolean ok = liste.remove(m);
        notifyObservers();
        return ok;
    }

    @Override
    public Mail update(Mail m) {
        int p = liste.indexOf(m);
        if (p < 0) {
            return null;
        }
        liste.set(p, m);
        notifyObservers();
        return m;
    }

    @Override
    public Mail read(Mail rech) {
        int p = liste.indexOf(rech);
        if (p < 0) {
            return null;
        }
        return liste.get(p);
    }

    @Override
    public List<Mail> getAll() {
        return liste;
    }
}
