package bibliotheque.mvc.controller;

import bibliotheque.metier.Mail;
import bibliotheque.mvc.model.DAOMail;
import bibliotheque.mvc.view.AbstractViewMail;

import java.util.List;

public class MailController {
    protected DAOMail model;
    protected AbstractViewMail view;

    public MailController(DAOMail model, AbstractViewMail view) {
        this.model = model;
        this.view = view;
        this.view.setController(this);
    }

    public Mail add(Mail m) {
        Mail nmail = model.add(m);
        return nmail;
    }

    public boolean remove(Mail m) {
        return model.remove(m);
    }

    public Mail update(Mail m) {
        return model.update(m);
    }

    public Mail search(Mail rech) {
        return model.read(rech);
    }

    public List<Mail> getAll() {
        List<Mail> l = model.getAll();
        return l;
    }
}
