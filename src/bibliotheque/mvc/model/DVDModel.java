package bibliotheque.mvc.model;

import bibliotheque.metier.DVD;

import java.util.ArrayList;
import java.util.List;

public class DVDModel extends DAODVD {

    private List<DVD> liste = new ArrayList<>();


    @Override
    public DVD add(DVD d) {
        boolean present = liste.contains(d);
        if (!present) {
            liste.add(d);
            notifyObservers();
            return d;
        } else {
            return null;
        }
    }

    @Override
    public boolean remove(DVD d) {
        boolean ok = liste.remove(d);
        notifyObservers();
        return ok;
    }

    @Override
    public DVD update(DVD d) {
        int p = liste.indexOf(d);
        if (p < 0) {
            return null;
        }
        liste.set(p, d);
        notifyObservers();
        return d;
    }

    @Override
    public DVD read(DVD rech) {
        int p = liste.indexOf(rech);
        if (p < 0) {
            return null;
        }
        return liste.get(p);
    }

    @Override
    public List<DVD> getAll() {
        return liste;
    }
}
