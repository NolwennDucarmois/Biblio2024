package bibliotheque.mvc.model;

import bibliotheque.metier.CD;

import java.util.ArrayList;
import java.util.List;

public class CDModel extends DAOCD {
    private List<CD> liste = new ArrayList<>();

    @Override
    public CD add(CD c) {
        boolean present = liste.contains(c);
        if (!present) {
            liste.add(c);
            notifyObservers();
            return c;
        } else {
            return null;
        }
    }

    @Override
    public boolean remove(CD c) {
        boolean ok = liste.remove(c);
        notifyObservers();
        return ok;
    }

    @Override
    public CD update(CD c) {
        int p = liste.indexOf(c);
        if (p < 0) return null;
        liste.set(p, c);
        notifyObservers();
        return c;
    }

    @Override
    public CD read(CD rech) {
        int p = liste.indexOf(rech);
        if (p < 0) {
            return null;
        }
        return liste.get(p);
    }

    @Override
    public List<CD> getAll() {
        return liste;
    }
}
