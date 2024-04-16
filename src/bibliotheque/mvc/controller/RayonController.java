package bibliotheque.mvc.controller;

import bibliotheque.metier.Rayon;
import bibliotheque.mvc.model.DAORayon;
import bibliotheque.mvc.view.AbstractViewRayon;

import java.util.List;

public class RayonController {
    protected DAORayon model;
    protected AbstractViewRayon view;

    public RayonController(DAORayon model, AbstractViewRayon view) {
        this.model = model;
        this.view = view;
        this.view.setController(this);
    }

    public List<Rayon> getAll() {
        List<Rayon> l = model.getAll();
        return l;
    }

    public Rayon add(Rayon r) {
        Rayon nr = model.add(r);
        return nr;
    }


    public boolean remove(Rayon r) {
        return model.remove(r);
    }

    public Rayon update(Rayon r) {
        return model.update(r);
    }

    public Rayon search(Rayon rech) {
        return model.read(rech);
    }
}
