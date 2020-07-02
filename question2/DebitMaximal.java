package question2;

import question1.Contributeur;
import question1.Cotisant;
import question1.GroupeDeContributeurs;
import question1.Visiteur;

public class DebitMaximal implements Visiteur<Integer>{

  public Integer visite(Contributeur c){
    return c.solde();
  }
  
  public Integer visite(GroupeDeContributeurs g){
    int res = 0;
    
    for(Cotisant c : g.getChildren()){ 
     int d = c.accepter(this);
        if ( d < res || res==0 ){                    
            res =d;
        } 
     }
    
    return res ;
  }
}