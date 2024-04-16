package bibliotheque.mvc.model;

import bibliotheque.metier.Rayon;

import java.util.ArrayList;
import java.util.List;

public class RayonModel extends DAORayon {
    private List<Rayon> liste = new ArrayList<>();

    @Override
    public Rayon add(Rayon r) {
        boolean present = liste.contains(r);
        if (!present) {
            liste.add(r);
            notifyObservers();
            return r;
        } else {
            return null;
        }
    }

    @Override
    public boolean remove(Rayon r) {
        boolean ok = liste.remove(r);
        notifyObservers();
        return ok;
    }

    @Override
    public Rayon update(Rayon r) {
        int p = liste.indexOf(r);
        if (p < 0) {
            return null;
        }
        liste.set(p, r);
        notifyObservers();
        return r;
    }

    @Override
    public Rayon read(Rayon rech) {
        int p = liste.indexOf(rech);
        if (p < 0) {
            return null;
        }
        return liste.get(p);
    }

    @Override
    public List<Rayon> getAll() {
        return liste;
    }
}
