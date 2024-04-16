package bibliotheque.mvc.model;

import bibliotheque.metier.Ouvrage;

import java.util.ArrayList;
import java.util.List;

public class OuvrageModel extends DAOOuvrage {
    private List<Ouvrage> liste = new ArrayList<>();

    @Override
    public Ouvrage add(Ouvrage ouv) {
        boolean present = liste.contains(ouv);
        if (!present) {
            liste.add(ouv);
            notifyObservers();
            return ouv;
        } else {
            return null;
        }
    }

    @Override
    public boolean remove(Ouvrage ouv) {
        boolean ok = liste.remove(ouv);
        notifyObservers();
        return ok;
    }

    @Override
    public Ouvrage update(Ouvrage ouv) {
        int p = liste.indexOf(ouv);
        if (p < 0) {
            return null;
        }
        liste.set(p, ouv);
        notifyObservers();
        return ouv;
    }

    @Override
    public Ouvrage read(Ouvrage rech) {
        int p = liste.indexOf(rech);
        if (p < 0) {
            return null;
        }
        return liste.get(p);
    }

    @Override
    public List<Ouvrage> getAll() {
        return liste;
    }
}
