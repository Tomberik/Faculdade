package imobiliaria;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Imobiliaria {

    public static ArrayList<Imoveis> imoveis = new ArrayList();
    public static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        exibirMenu();
        
    }

    public static void exibirMenu() {
        while (true) {
            System.out.println("1. Cadastrar Imóvel");
            System.out.println("2. Listar Imóveis  ");
            System.out.println("3. Excluir Imóvel  ");
            System.out.println("4. Pesquisar Imóvel");
            System.out.println("5. Atualizar       ");
            System.out.println("6. SAIR            ");
            System.out.print("SUA OPCAO:         ");
            int opcao = Integer.parseInt(scan.nextLine());
            switch (opcao) {
                case 1:
                    cadastrar();
                    break;
                case 2:
                    listar();
                    break;
                case 3:
                    excluir();
                    break;
                case 4:
                    pesquisar();
                    break;
                case 5:
                    atualizar();
                    break;
                case 6:
                    System.out.println("\nEncerrando\n");
                    System.exit(0);
                    break;

                default:
                    System.out.println("\nOpção inválida. Afff.\n");
                    break;
            }

        }

    }

    public static void cadastrar() {
        ArrayList<Imoveis> imoveis = new ArrayList();
            System.out.println("Cadastrar Imóvel: ");
            System.out.println("Código: ");
            int codigo = Integer.parseInt(scan.nextLine());
            System.out.print("Nome do Imóvel: ");
            String nome = (scan.nextLine());
            System.out.print("Valor do Aluguel: ");
            double aluguel = Double.parseDouble(scan.nextLine());            
            for (int i = 0; i < imoveis.size(); i++) {
                Imoveis imovel = new Imoveis(codigo, nome, aluguel);
                imoveis.add(imovel);
                try {
            FileOutputStream fos = new FileOutputStream("imoveis.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(imoveis);
            oos.close();
            System.out.println("\nDados foram salvos com sucesso.\n");
        } catch (Exception exc) {
            System.out.println(exc.getMessage());
        }
        }
    }

    public static String converte(boolean boo) {
        String str = "";
        if (boo == true) {
            str = "Sim";
        } else {
            str = "Não";
        }
        return str;
    }

    public static void listar() {
        ArrayList<Imoveis> imoveis = new ArrayList();
        try{
            FileInputStream fis = new FileInputStream("imoveis.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            imoveis = (ArrayList) ois.readObject();
            ois.close();
        } catch (Exception exc) {
            System.out.println(exc.getMessage());
        }
        
        for(int i = 0; i < imoveis.size(); i++){
            System.out.println("Código: " + imoveis.get(i).getCodigo() + "Nome: " + imoveis.get(i).getNome() + "Valor: " + imoveis.get(i).getAluguel() + "Locado? " + imoveis.get(i).isLocado());
        }
        /* 
        if (imoveis.size() != 0) {

            System.out.println("Código: " + imoveis.get(0) + " Nome " + imoveis.get(0).getNome() + " Valor do Aluguel: " + imoveis.get(0).getAluguel() + " Situação: " + imoveis.get(0).isLocado());
        } else {
            System.out.println("");
            System.out.println("Não há imóveis cadastrados.");
            System.out.println("");
        }
         */

    }

    public static void excluir() {
        System.out.println("Excluir Imóvel: ");
        for (int i = 0; i < imoveis.size(); i++) {
            System.out.println("Nome: " + imoveis.get(i).getNome());
        }
        System.out.print("Informe o nome a ser excluído: ");
        String nome = (scan.nextLine());

        boolean encontrado = false;
        for (int i = 0; i < imoveis.size(); i++) {
            if (imoveis.get(i).getNome().equals(nome)) {
                imoveis.remove(i);
                encontrado = true;
                break;
            }
        }
        if (encontrado) {
            System.out.println("\nImóvel excluído com sucesso.\n");
        } else {
            System.out.println("\nImóvel não foi encontrado.\n");
        }
    }

    public static void pesquisar() {
        System.out.print("Informe o nome completo ou parte do nome: ");
        String nome = scan.nextLine();
        System.out.println("Imóveis Encontrados: " + imoveis.size());

    }

    public static void atualizar() {
        System.out.print("\nInforme o nome completo do imóvel a ser atualizado: ");
        String nome = scan.nextLine();
        boolean sucesso = false;
        for (int i = 0; i < imoveis.size(); i++) {
            {
                String conf;
                System.out.println("Imóvel Locado?: ");
                conf = scan.nextLine();
                if (conf == "sim") {
                    imoveis.get(i).setLocado(true);
                    System.out.println("\nAtualizado com sucesso.\n");
                    sucesso = true;
                } else {
                    imoveis.get(i).setLocado(false);
                }
            }

            if (sucesso != true) {
                System.out.println("Imóvel não encontrado.");
            }

        }

    }

    public static void estatisticas() {
        int locados = 0;
        for (int i = 0; i < imoveis.size(); i++) {
            if (imoveis.get(i).isLocado() == true) {
                locados++;
            } else {
                locados++;
            }
        }
        System.out.println("Total de Imóveis: " + imoveis.size());
        System.out.println("Imóveis Locados: " + imoveis.get(locados) + " ((locado/imoveis.size())*100)%");
        System.out.println("Imóveis Lives: " + (imoveis.size() - locados));
    }

    public static void alugueis() {
        double aluguel[] = new double[imoveis.size()];
        double maior = 0, menor = 0;

        for (int i = 0; i < aluguel.length; i++) {
            imoveis.get(i).getAluguel();
            if (aluguel[i] > maior) {
                maior = aluguel[i];
            }
            for (int j = 0; j < aluguel.length; j++) {
                if (aluguel[j] < menor) {
                    menor = aluguel[j];
                }
            }
            System.out.println("Maior valor: " + maior);
            System.out.println("Menor valor: " + menor);
        }

    }

}
