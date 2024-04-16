package bibliotheque.mvc.controller;

import bibliotheque.metier.CD;
import bibliotheque.mvc.model.DAOCD;
import bibliotheque.mvc.view.AbstractViewCD;

import java.util.List;

public class CDController {
    protected DAOCD model;
    protected AbstractViewCD view;

    public CDController(DAOCD model, AbstractViewCD view) {
        this.model = model;
        this.view = view;
        this.view.setController(this);
    }

    public List<CD> getAll() {
        List<CD> l = model.getAll();
        return l;
    }

    public CD add(CD c) {
        CD ncd = model.add(c);
        return ncd;
    }

    public boolean remove(CD c) {
        return model.remove(c);
    }

    public CD update(CD c) {
        return model.update(c);
    }

    public CD search(CD rech) {
        return model.read(rech);
    }
}
