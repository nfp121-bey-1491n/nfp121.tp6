package question3;

import question1.*;
import question2.*;
import java.util.*;
import org.jdom.*;

public class Memento {
    private Element state;
     
    public Memento(Cotisant c) {
       this.state = c.accepter(new VisiteurToXML());
    }

    public void setState(Cotisant c) {
       setState(c, state);
    }
    
    public void setState(Cotisant c, Element e) {
        if (c instanceof Contributeur) {
            setState((Contributeur)c, e);
        } else {
            setState((GroupeDeContributeurs)c, e);
        }
    }
    
    public void setState(Contributeur c, Element e) {
        if (c.nom().equals(e.getAttribute("nom").getValue())){
            c.affecterSolde(Integer.parseInt(e.getAttribute("solde").getValue()));
        }
    }

    public void setState(GroupeDeContributeurs grp, Element e) {
        if (grp.nom().equals(e.getAttribute("nom").getValue())) {
            
            List childsElements = e.getChildren();
            List<Cotisant> CotisantsChilds = grp.getChildren();
            
            for (int i = 0; i < CotisantsChilds.size(); i++) {
                Element elem = (Element)childsElements.get(i);
                Cotisant c = CotisantsChilds.get(i);
                setState(c, elem);
            }
        }
    }
}