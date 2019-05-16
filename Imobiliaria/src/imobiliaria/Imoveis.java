

package imobiliaria;



public class Imoveis {
    
    private int codigo;
    private String nome;
    private double aluguel;
    private boolean locado = false;

    public Imoveis() {
    }

    public Imoveis(int codigo, String nome, double aluguel, boolean locado) {
        this.codigo = codigo;
        this.nome = nome;
        this.aluguel = aluguel;
        this.locado = locado;
    }

    public Imoveis(int codigo, String nome, double aluguel) {
        this.codigo = codigo;
        this.nome = nome;
        this.aluguel = aluguel;
    }
    
    
    

    /**
     * @return the codigo
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
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
     * @return the aluguel
     */
    public double getAluguel() {
        return aluguel;
    }

    /**
     * @param aluguel the aluguel to set
     */
    public void setAluguel(double aluguel) {
        this.aluguel = aluguel;
    }

    /**
     * @return the locado
     */
    public boolean isLocado() {
        return locado;
    }

    /**
     * @param locado the locado to set
     */
    public void setLocado(boolean locado) {
        this.locado = locado;
    }
    
}
