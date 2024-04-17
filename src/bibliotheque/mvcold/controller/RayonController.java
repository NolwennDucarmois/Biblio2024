package bibliotheque.mvcold.controller;

import bibliotheque.metier.Exemplaire;
import bibliotheque.metier.Rayon;
import bibliotheque.mvcold.model.DAO;
import bibliotheque.mvcold.model.DAOSpecialRayon;
import bibliotheque.mvcold.view.AbstractView;

import java.util.List;

public class RayonController extends Controller<Rayon> implements ControllerSpecialRayon {

    public RayonController(DAO<Rayon> model, AbstractView<Rayon> view) {
        super(model, view);
    }

    public List<Exemplaire> listerExemplaires(Rayon r) {
        return ((DAOSpecialRayon) model).listerExemplaires(r);
    }

}
