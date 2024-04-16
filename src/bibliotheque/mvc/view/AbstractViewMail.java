package bibliotheque.mvc.view;

import bibliotheque.metier.Mail;
import bibliotheque.mvc.controller.MailController;
import bibliotheque.mvc.observer.Observer;

import java.util.List;

public abstract class AbstractViewMail implements Observer {
    protected MailController mailController;
    protected List<Mail> lmail;

    public void setController(MailController mailController) {
        this.mailController = mailController;
    }

    public abstract void menu();

    public abstract void affList(List lmail);

    public List<Mail> getAll() {
        return lmail;
    }

    @Override
    public void update(List lmail) {
        this.lmail = lmail;
        affList(lmail);
    }

}
