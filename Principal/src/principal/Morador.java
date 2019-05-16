

package principal;



public class Morador extends Pessoa{
    
  private String telefone;
  private int andar; 
  private int apartamento;

    public Morador(String nome, int idade, char sexo, String telefone) {
        super (nome, idade, sexo);
        this.telefone = telefone;
        
    }

    public Morador() {
    }

    
  
    /**
     * @return the telefone
     */
  
    public String getTelefone() {
        return telefone;
    }

    /**
     * @param telefone the telefone to set
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    /**
     * @return the andar
     */
    public int getAndar() {
        return andar;
    }

    /**
     * @param andar the andar to set
     */
    public void setAndar(int andar) {
        this.andar = andar;
    }

    /**
     * @return the apartamento
     */
    public int getApartamento() {
        return apartamento;
    }

    /**
     * @param apartamento the apartamento to set
     */
    public void setApartamento(int apartamento) {
        this.apartamento = apartamento;
    }
}
