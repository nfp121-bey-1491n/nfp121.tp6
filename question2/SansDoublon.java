package question2;

import question1.*;
import java.util.*;

public class SansDoublon implements Visiteur<Boolean>{
  public Boolean visite(Contributeur c){
    return c.solde() >=0;
  }
  
  public Boolean visite(GroupeDeContributeurs g){
    boolean res = false;
    if(g.nombreDeCotisants()>0){  
         
        List<Cotisant> l =sansDoublon(g); 
        for(Cotisant cot : l){ 
            if(cot.accepter(this))
            { res= true;} 
        } 
        
     }
    return res;
  }
  
  public List<Cotisant> sansDoublon(Cotisant g)
  {
       List<Cotisant> l = new ArrayList<Cotisant>();   
       if(g instanceof Contributeur ){
           Contributeur con = (Contributeur)g;
           for(Cotisant cot : l){
               if(cot.nom().equals(con.nom())) break;
               else {l.add(con);}
           }
          
       }
       else if(g instanceof GroupeDeContributeurs){
           GroupeDeContributeurs g1 = (GroupeDeContributeurs) g;
           Iterator<Cotisant> it = g1.iterator();
           while(it.hasNext()){
              
               Cotisant cs = it.next();
              if(l.contains(cs)) break;
              for(Cotisant css : l){
                    if(css.nom().equals(g1.nom())) break;
                    else{sansDoublon(g1);}
              }
           }
       }
    
       return l;
    }
}