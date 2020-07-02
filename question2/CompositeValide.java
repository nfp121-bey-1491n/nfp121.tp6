package question2;

import question1.Contributeur;
import question1.Cotisant;
import question1.GroupeDeContributeurs;
import question1.Visiteur;

public class CompositeValide implements Visiteur<Boolean>{
  // Le solde de chaque contributeur doit être supérieur ou égal à 0 
  // et il n’existe pas de groupe n’ayant pas de contributeurs.
  
  public Boolean visite(Contributeur c){
    return c.solde() >=0;
  }
  
  public Boolean visite(GroupeDeContributeurs g){
    boolean res = false;
    
    if(g.nombreDeCotisants()<=0){
          res=false;
            return res; 
    } 
        
    for(Cotisant c : g.getChildren()){ 
        if( !c.accepter(this)){ 
            res=false;
            return res; 
        } 
    }
    res=true; 
  
    return res ;
  }
}