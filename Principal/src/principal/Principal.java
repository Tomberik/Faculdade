package principal;

import java.util.Scanner;

public class Principal {

    static Scanner scan = new Scanner(System.in);
    static Predio p = new Predio();
    
    public static void main(String[] args) {
        exibirMenu();
    }

    {

        // cria um novo prÃ©dio
        Predio p = new Predio("EdifÃ­cio JÃ©ssica", "Av. Princesa Patricia");

        // cria um novo morador
        Morador m = new Morador("Fabiana Lemos", 19, 'F', "3261-4323");

        // vamos colocar este morador no segundo apartamento do terceiro andar
        m.setAndar(3);
        m.setApartamento(2);
        // lembre-se de que os Ã­ndices das matrizes comeÃ§am em 0
        p.getAndares()[1].getApartamentos()[2].setMorador(m);

        // vamos obter o morador do segundo apartamento do terceiro andar
        Morador m2 = p.getAndares()[1].getApartamentos()[2].getMorador();

        // o morador foi encontrado?
        if (m2 != null) {
            System.out.println("Morador encontrado. Os dados sÃ£o:");
            System.out.println("Nome: " + m2.getNome());
            System.out.println("Idade: " + m2.getIdade());
            System.out.println("Andar: " + m2.getAndar());
            System.out.println("Apartamento: " + m2.getApartamento());
        } else {
            System.out.println("NÃ£o hÃ¡ morador no andar e apartamento informado.");
        }

        // finalmente...
        System.out.println("O nome do prÃ©dio Ã©: " + p.getNome());
        System.out.println("O endereÃ§o do prÃ©dio Ã©: " + p.getEndereco());

    }
    // Chama o menu de opÃ§Ãµes

    // MÃ©todo exibirMenu(), exibe menu de opÃ§Ãµes
    public static void exibirMenu() {

        while (true) {
            System.out.println("..........INICIO.........");
            System.out.println("1.ADICIONAR MORADOR: ");
            System.out.println("2.QUANTIDADE DE APARTAMENTOS OCUPADOS EM CADA ANDAR: ");
            System.out.println("3.O ANDAR COM MAIOR E MENOR NUMERO DE PESSOAS: ");
            System.out.println("4.QUANTIDADE DE MORADORES COM IDADE MENOR QUE 30 ANOS: ");
            System.out.println("5.PORCENTAGEM OCUPADA EM CADA ANDAR: ");
            System.out.println("6.QUANTIDADE DE MORADORES DO SEXO FEMININO DO PREDIO: ");
            System.out.println("7.PESQUISAR MORADOR POR NOME: ");
            System.out.println("8.SAIR");
            System.out.println("SUA OPCAO: ");            
            int opcao = Integer.parseInt(scan.nextLine());

            // switcth-case
            switch (opcao) {
                case 1:
                    adicionarMorador();
                    break;
                case 2:
                    apartamentosOcupados();
                    break;
                case 3:
                    maiorMenor();
                    break;
                case 4:
                    idadeInferior();
                    break;
                case 5:
                    porcentagem();
                    break;
                case 6:
                    sexoFeminino();
                    break;
                case 7:
                    pesquisarNome();
                    break;
                case 8:
                    System.exit(0);
                    System.out.println("\nFINALIZADO.");
                default:
                    System.out.println("ENTRADA INVÁLIDA!\n");
            }
        }
    }


    // MÃ©todo adicionarMorador(), adiciona novos moradores no prÃ©dio
    public static void adicionarMorador() {

        System.out.println("........Adicionar.....");

        // Pede o andar a ser inserido o novo morador
        System.out.println("\nInforme o numero do  andar: ");
        int andar = Integer.parseInt(scan.nextLine());

        // verifica o andar informado, se for <= 0 ou > 5, pede novamente
        while (andar <= 0 || andar > 5) {
            System.out.println("\nInforme um andar de 1 a 5: ");
            andar = Integer.parseInt(scan.nextLine());

        }

        // pede o apartamento a ser inserido o novo morador
        System.out.println("\nInforme apartamento: ");
        int apt = Integer.parseInt(scan.nextLine());

        // verifica o apartamento informado, se for <= 0 ou > 10, pede novamente
        while (apt <= 0 || apt > 10) {
            System.out.println("\nInforme um apatamento de 1 a 10: ");
            apt = Integer.parseInt(scan.nextLine());

        }

        // se o apartamento informado no andar informado estiver livre, pede os dados
        if (p.getAndares()[andar - 1].getApartamentos()[apt - 1].getMorador() == null) {

            System.out.println("\nNome: ");
            String nome = scan.nextLine().toUpperCase();

            System.out.println("\nIdade: ");
            int idade = Integer.parseInt(scan.nextLine());

            System.out.println("\nSexo: ");
            char sexo = scan.next().toUpperCase().charAt(0);
            scan.nextLine();

            System.out.println("\nTelefone: ");
            String tel = scan.nextLine();

            // cria novo objeto morador
            Morador m = new Morador(nome, idade, sexo, tel);

            // armazena o nÂº do andar e do apartamento do novo morador
            m.setAndar(andar);
            m.setApartamento(apt);

            // armazena novo objeto morador no apartamento e andar informados
            p.getAndares()[andar - 1].getApartamentos()[apt - 1].setMorador(m);

            System.out.println("\nMORADOR INSERIDO COM SUCESSO!\n");

            // se morador for != null   
        } else {
            System.out.println("\nAPARTAMENTO OCUPADO!\n");

        }
    }
    // MÃ©todo apartamentosOcupados(), Conta a quantidade de apartamentos ocupados em cada andar

    public static void apartamentosOcupados() {

        System.out.println(".....APARTAMENTOS OCUPADOS....");

        int apartamentosOcupados = 0;// variÃ¡vel contadora

        // varredura pelos apartamentos de cada andar
        for (Andar andar : p.getAndares()) {
            for (Apartamento apartamento : andar.getApartamentos()) {

                // se o apartamento estiver ocupado incrementa 1 Ã  aptsOcup
                if (apartamento.getMorador() != null) {

                    apartamentosOcupados++;// incremento

                }

            }
            // mostra o resultado do andar especÃ­fico
            System.out.printf("Andar %d: %d%n", andar.getAndar(), apartamentosOcupados);
            apartamentosOcupados = 0; // renicia a variÃ¡vel
        }
    }
    // MÃ©todo maiorMenor(), encontra os andares com maior e menor quantidade de moradores

    public static void maiorMenor() {

        System.out.println("....MAIS APTO E MENOS OCUPADOS...");

        int maior = 0; // conta o andar com o maior nÃºmero de moradores
        int menor = 877; // conta o andar com o menor nÃºmero de moradores
        int andarMaior = 0; // irÃ¡ definir qual andar tem a maior quantidade de moradores
        int andarMenor = 0; // irÃ¡ definir qual andar tem a menor quantidade de moradores

        for (Andar andar : p.getAndares()) {

            // verifica se a quantidade de moradores é maior que a variável maior
            int quantMoradores = 0;
            if (Andar.quantMoradores() > maior) {
                maior = Andar.quantMoradores(); // se for, define maior com a quantidade de moradores do andar
                andarMaior = andar.getAndar(); // se nenhum outro andar tiver mais moradores que a variÃ¡vel maior,
                // define a variÃ¡vel andarMaior com o nÃºmero do respectivo andar
            }

            // mesma idÃ©ia do primeiro if
            if (andar.quantMoradores() < menor) {
                menor = andar.quantMoradores();
                andarMenor = andar.getAndar();
            }

        }
        // mostra na tela 
        System.out.println("Andar com a maior quantidade de moradores: " + andarMaior);
        System.out.println("Andar com a menor quantidade de moradores: " + andarMenor);

    }
    // MÃ©todo idadeInferior(), conta moradores com idades inferiores a 30 anos

    public static void idadeInferior() {

        System.out.println("===================== IDADES INFERIORES =====================");

        int moradores = 0;// variÃ¡vel contadora

        // varredura pelos os andares
        for (Andar andar : p.getAndares()) {
            for (Apartamento apartamento : andar.getApartamentos()) {
                // se morador for diferente de null e sua idade for < 30
                if ((apartamento.getMorador() != null)
                        && (apartamento.getMorador().getIdade() < 30)) {

                    moradores++; // incrementa 1 Ã  variÃ¡vel contadora

                }
            }
        }
        // mostra na tela
        System.out.println("Quantidade de moradores com idade inferior a 30 anos: " + moradores);

    }
    // MÃ©todo porcentagem(), calcula a porcentagem de moradores por andar

    public static void porcentagem() {

        System.out.println("......MOSTRAR PORCENTAGEM.....");

        double moradores = 0; // contador de moradores por andar

        // faz uma varredura pelo prÃ©dio
        for (Andar andar : p.getAndares()) {
            for (Apartamento apartamento : andar.getApartamentos()) {
                if (apartamento.getMorador() != null) {
                    moradores++;

                }
            }
            // mostra na tela
            System.out.printf("Andar %d: %.1f%%%n", andar.getAndar(), ((moradores / 10) * 100));
            moradores = 0;// renicia a variÃ¡vel
        }
    }
    // MÃ©todo sexoFem(), conta a quantidade de mulheres no prÃ©dio

    public static void sexoFeminino() {

        System.out.println("....MORADORES SEXO FEMININO........");

        int sexoFeminino = 0; // variÃ¡vel contadora
        // varredura pelo prÃ©dio
        for (Andar andar : p.getAndares()) {
            for (Apartamento apartamento : andar.getApartamentos()) {
                // se o morador for do sexo femino,
                if (apartamento.getMorador() != null && apartamento.getMorador().getSexo() == 'F') {
                    sexoFeminino++; // incrementa 1 a fem
                }
            }
        }
        // mostra na tela
        System.out.println("Quantidade de moradores do sexo feminino: " + sexoFeminino);
    }
    // MÃ©todo pesquisarNome(), pesquisa moradores pelo nome

    public static void pesquisarNome() {

        System.out.println(".....PESQUISAR POR NOME.....");

        boolean encontrado = false;

        System.out.println("Nome: ");// pede o nome
        String nome = scan.nextLine().toUpperCase();
        System.out.println();

        // varredura pelo prÃ©dio atrÃ¡s do nome informado
        for (Andar andar : p.getAndares()) {
            for (Apartamento apartamento : andar.getApartamentos()) {
                if (apartamento.getMorador() != null && apartamento.getMorador().getNome().equals(nome)) {
                    encontrado = true;
                    System.out.println(apartamento.getMorador());

                }
            }
        }

        if (!encontrado) {
            System.out.println("....MORADOR NAO ENCONTRADO....!\n");
        }
    }
}


