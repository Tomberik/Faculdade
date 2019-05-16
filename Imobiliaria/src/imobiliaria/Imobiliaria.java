package imobiliaria;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Imobiliaria {

    static ArrayList<Imoveis> imoveis = new ArrayList();
    static Scanner scan = new Scanner(System.in);

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
                    cadastrarImoveis();
                    break;
                case 2:
                    listarImoveis();
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
                    System.out.println("Encerrando");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Opção inválida.");
                    break;
            }

        }

    }

    public static void cadastrarImoveis() {

        ArrayList<Imoveis> imoveis = new ArrayList();
        /*
        try {
            System.out.println("Cadastrar Imóvel: ");
            System.out.println("Código: ");
            int codigo = Integer.parseInt(scan.nextLine());
            System.out.print("Nome do Imóvel: ");
            String nome = (scan.nextLine());
            System.out.print("Valor do Aluguel: ");
            double aluguel = Double.parseDouble(scan.nextLine());

            Imoveis imovel = new Imoveis(codigo, nome, aluguel);
            imoveis.add(imovel);

            FileOutputStream fos = new FileOutputStream("imoveis.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(imoveis);
            oos.close();
            System.out.println("\nDados foram salvos com sucesso.\n");
        } catch (Exception exc) {
            System.out.println(exc.getMessage());
        }
*/
    }

    public static void listarImoveis() {
        
        try { 
                FileInputStream fis = new FileInputStream("imoveis.txt");
                ObjectInputStream ois = new ObjectInputStream(fis);
                Imoveis imoveis = (Imoveis) ois.readObject();
                System.out.println("Código: " + imoveis.getCodigo() + 
                        " Nome: " + imoveis.getNome() + 
                        " Valor: " + imoveis.getAluguel());
                ois.close();
        } catch (Exception exc) {
            System.out.println(exc.getMessage());
        }

    }

    public static void excluir() {
        System.out.println("Excluir Imóvel: ");
        for (int i = 0; i < imoveis.size(); i++) {
            System.out.print("Informe o nome a ser excluído: ");
            String nome = (scan.nextLine());
            if (nome == imoveis.get(i).getNome()) {
                imoveis.remove(i);
                System.out.println("Imóvel Excluído com Sucesso!");
            } else {
                System.out.println("Nome não Cadastrado.");
            }
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
