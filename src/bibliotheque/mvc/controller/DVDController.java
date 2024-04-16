package bibliotheque.mvc.controller;

import bibliotheque.metier.DVD;
import bibliotheque.mvc.model.DAODVD;
import bibliotheque.mvc.view.AbstractViewDVD;

import java.util.List;

public class DVDController {

    protected DAODVD model;
    protected AbstractViewDVD view;

    public DVDController(DAODVD model, AbstractViewDVD view) {
        this.model = model;
        this.view = view;
        this.view.setController(this);
    }

    public List<DVD> getAll() {
        List<DVD> l = model.getAll();
        return l;
    }

    public DVD add(DVD d) {
        DVD ndvd = model.add(d);
        return ndvd;
    }


    public boolean remove(DVD d) {
        return model.remove(d);
    }

    public DVD update(DVD d) {
        return model.update(d);
    }

    public DVD search(DVD rech) {
        return model.read(rech);
    }
}