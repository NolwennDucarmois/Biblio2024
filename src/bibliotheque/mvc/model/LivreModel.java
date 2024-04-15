package bibliotheque.mvc.model;

import bibliotheque.metier.Livre;

import java.util.ArrayList;
import java.util.List;

public class LivreModel extends DAOLivre {
    private List<Livre> liste = new ArrayList<>();

    @Override
    public Livre add(Livre li) {
        boolean present = liste.contains(li);
        if (!present) {
            liste.add(li);
            notifyObservers();
            return li;
        } else {
            return null;
        }
    }

    @Override
    public boolean remove(Livre li) {
        boolean ok = liste.remove(li);
        notifyObservers();
        return ok;
    }

    @Override
    public Livre update(Livre li) {
        int p = liste.indexOf(li);
        if (p < 0) {
            return null;
        }
        liste.set(p, li);
        notifyObservers();
        return li;
    }

    @Override
    public Livre read(Livre rech) {
        int p = liste.indexOf(rech);
        if (p < 0) {
            return null;
        }
        return liste.get(p);
    }

    @Override
    public List<Livre> getAll() {
        return liste;
    }
}
