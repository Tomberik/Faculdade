

package principal;



public class Predio {
    
private String nome;
private String endereco;
private Andar andares[];

    public Predio(String nome, String endereco) {
        this.nome = nome;
        this.endereco = endereco;
        
        
        andares = new Andar[5];
        for(int i = 0; i < andares.length; i++){
            andares[i] = new Andar(i + 1);
    }

    }

    public Predio() {
    }
    
    

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the endereco
     */
    public String getEndereco() {
        return endereco;
    }

    /**
     * @param endereco the endereco to set
     */
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    /**
     * @return the andares
     */
    public Andar[] getAndares() {
        return andares;
    }

    /**
     * @param andares the andares to set
     */
    public void setAndares(Andar[] andares) {
        this.andares = andares;
    }
}
