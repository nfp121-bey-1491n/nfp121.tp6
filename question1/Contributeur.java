package question1;


public class Contributeur extends Cotisant{
  private int solde;
  
  public Contributeur(String nom, int somme){
    super(nom);
    if(somme<0){
      throw new RuntimeException
      ("la somme nÈgative");
    }
    
    this.solde = somme;
  }
  
  public int solde(){
    return this.solde;
  }
  
  public int nombreDeCotisants(){
    return 1;
  }
    
  public void debit(int somme) throws SoldeDebiteurException,RuntimeException{
      if(somme<0)throw new RuntimeException("somme debite negative");
      
      if(somme>this.solde){
          throw new SoldeDebiteurException("solde insuffisante");
      }
      else
      this.solde-=somme;
    }
    
    /**
     * throws RuntimeException new RuntimeException("nombre n√©gatif !!!");
     */
    public void credit(int somme){
      if(somme<0)throw new RuntimeException ("somme credite negative");
      this.solde+=somme;
    }
    
    /**
     * throws RuntimeException new RuntimeException("nombre n√©gatif !!!");
     */
  public void affecterSolde(int somme)throws RuntimeException{
     if(somme <0) throw new RuntimeException ("nombre nÈgatif");
     
     try{
       debit(solde());
       credit(somme); 
     }catch(SoldeDebiteurException sde){
      this.solde = somme; 
     }
  }
  
public <T> T accepter(Visiteur<T> visiteur){
    return visiteur.visite(this);
  }
  
  public String toString(){
    return "<Contributeur : " + nom + "," + solde + ">";
  }

}
