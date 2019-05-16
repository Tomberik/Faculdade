

package principal;



public class Apartamento {
    
    private int numero; 
    private Morador morador;

    
       public Apartamento(int numero, Morador moradores, int quantMoradores) {
        this.numero = numero;
        this.morador = new Morador();
        
        for(int i = 0; i < quantMoradores; i++){
          this.morador = new Morador();  
        } 
        
       
    }
        
    

    public Apartamento() {
    }
       
    
    
    
    

    /**
     * @return the numero
     */
    public int getNumero() {
        return numero;
    }

    /**
     * @param numero the numero to set
     */
    public void setNumero(int numero) {
        this.numero = numero;
    }

    /**
     * @return the morador
     */
    public Morador getMorador() {
        return morador;
    }

    /**
     * @param morador the morador to set
     */
    public void setMorador(Morador morador) {
        this.morador = morador;
    }
    
}
