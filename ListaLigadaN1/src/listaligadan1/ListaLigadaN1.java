package listaligadan1;

/**
 *
 * @author Erik
 */
import java.util.ArrayList;
import java.util.Scanner;

class Produto {

    int cod;
    String nome;
    double preco;

    public Produto(int cod, String nome, double preco) {
        this.cod = cod;
        this.nome = nome;
        this.preco = preco;

    }

    public Produto() {
    }

    public class ListaLigadaN1 {

        java.util.Scanner scan = new Scanner(System.in);
        Lista lista = new Lista(); /*Essa linha serviria pra qnd fosse listar
                                   os produtos existentes. Mas tá dando conflito
                                    */
        

        public void main(String[] args) {
            menu();
        }

        public void menu() {
            while (true) {
                System.out.println("1-Inserir posição");
                System.out.println("2-Remover posição");
                System.out.println("3-Pesquisar Nome");
                System.out.println("4-Listar");
                System.out.println("5-Sair");
                System.out.println("Opção: ");
                int opcao = Integer.parseInt(scan.nextLine());

                switch (opcao) {
                    case 1:
                        addPos();
                        break;
                    case 2:
                        delPos();
                        break;
                    case 3:
                        searchNome();
                        break;                    
                    case 4:
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Opção inválida!");
                        break;
                }
            }
        }

        public void addPos() {
            Produto produtos = new Produto();            
            
            System.out.println("\nNome: ");
            produtos.nome = (scan.nextLine());
            System.out.println("Código: ");
            produtos.cod = (Integer.parseInt(scan.nextLine()));
            System.out.println("\nPreço: ");
            produtos.preco = (Integer.parseInt(scan.nextLine()));
            System.out.println("Posição: ");
            int pos = Integer.parseInt(scan.nextLine());

            try {
                lista.addPos(pos, produtos);
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("\nExceção: " + e.getMessage());
                lista.addF(produtos);
                System.out.println("Produto inserido no final da lista.");
            }

            System.out.println("\nInserido com sucesso!\n");
        }

        

        public void delPos(){
        System.out.println("Informe em qual posição remover: ");
        int pos = Integer.parseInt(scan.nextLine());
        
        try{
            lista.delPos(pos);
        }
        catch(ArrayIndexOutOfBoundsException e){
            System.out.println("\nExceção: " + e.getMessage());
            lista.delF();
            System.out.println("Última posição da lista removida.");
        }
        
        System.out.println("\nRemovido com sucesso!\n");
    }
    
    public void searchNome(){
        System.out.println("Informe o nome: ");
        String nome = scan.nextLine();
        System.out.println();
        System.out.println(lista.pesquisar(nome));
    } 
    }
}
