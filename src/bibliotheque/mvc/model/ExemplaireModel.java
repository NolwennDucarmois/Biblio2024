package bibliotheque.mvc.model;

import bibliotheque.metier.Exemplaire;

import java.util.ArrayList;
import java.util.List;

public class ExemplaireModel extends DAOExemplaire {
    private List<Exemplaire> liste = new ArrayList<>();

    @Override
    public Exemplaire add(Exemplaire ex) {
        boolean present = liste.contains(ex);
        if (!present) {
            liste.add(ex);
            notifyObservers();
            return ex;
        } else {
            return null;
        }
    }

    @Override
    public boolean remove(Exemplaire ex) {
        boolean ok = liste.remove(ex);
        notifyObservers();
        return ok;
    }

    @Override
    public Exemplaire update(Exemplaire ex) {
        int p = liste.indexOf(ex);
        if (p < 0) {
            return null;
        }
        liste.set(p, ex);
        notifyObservers();
        return ex;
    }

    @Override
    public Exemplaire read(Exemplaire rech) {
        int p = liste.indexOf(rech);
        if (p < 0) {
            return null;
        }
        return liste.get(p);
    }

    @Override
    public List<Exemplaire> getAll() {
        return liste;
    }

}
