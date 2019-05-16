

package principal;



public class Andar {
    
private int andar;
private Apartamento apartamentos[];
private Morador moradores[]; // vetor de moradores



    public Andar(int andar, Morador moradores, int quantMoradores) {
        this.andar = andar;
        this.moradores = new Morador[quantMoradores];
        
        apartamentos = new Apartamento[10];
        for(int i = 0; i < apartamentos.length; i++){
        this.apartamentos[i] = new Apartamento();
        }  
    }

    public Andar() {
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
     * @return the apartamentos
     */
    public Apartamento[] getApartamentos() {
        return apartamentos;
    }

    /**
     * @param apartamentos the apartamentos to set
     */
    public void setApartamentos(Apartamento[] apartamentos) {
        this.apartamentos = apartamentos;
    }

}
