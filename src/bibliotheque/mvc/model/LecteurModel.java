package bibliotheque.mvc.model;

import bibliotheque.metier.Lecteur;

import java.util.ArrayList;
import java.util.List;

public class LecteurModel extends DAOLecteur {
    private List<Lecteur> liste = new ArrayList<>();

    @Override
    public Lecteur add(Lecteur lec) {
        boolean present = liste.contains(lec);
        if (!present) {
            liste.add(lec);
            notifyObservers();
            return lec;
        } else {
            return null;
        }
    }

    @Override
    public boolean remove(Lecteur lec) {
        boolean ok = liste.remove(lec);
        notifyObservers();
        return ok;
    }

    @Override
    public Lecteur update(Lecteur lec) {
        int p = liste.indexOf(lec);
        if (p < 0) return null;
        liste.set(p, lec);
        notifyObservers();
        return lec;
    }

    @Override
    public Lecteur read(Lecteur rech) {
        int p = liste.indexOf(rech);
        if (p < 0) return null;
        return liste.get(p);
    }

    @Override
    public List<Lecteur> getAll() {
        return liste;
    }
}
