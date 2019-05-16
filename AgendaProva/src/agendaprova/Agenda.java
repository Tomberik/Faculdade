

package agendaprova;

import java.util.Scanner;

public class Agenda {
    
    Contato contatos[] = new Contato[10];
  Scanner scan = new Scanner(System.in);
  
  public void exibirMenu() {
    while (true) {
      System.out.println("1. Cadastrar Contato");      
      System.out.println("2. Pesquisar Contatos");      
      System.out.println("3. Excluir Contato");
      System.out.println("4. Sair");
      System.out.print("Sua opção: ");
      int opcao = Integer.parseInt(scan.nextLine());

      switch (opcao) {
        case 1:
          cadastrarContato();
          break;
        case 2:
          pesquisarContato();
          break;
        case 3:
          excluirContato();
          break;
        case 4:
         System.out.println("\nAté Logo!\n");
          System.exit(0);
          break;
       
      }
    }
  }
    
  public void cadastrarContato(){
    boolean cheio = true;
      for(int i = 0; i < contatos.length; i++){
        if(contatos[i] == null){
          System.out.println("\nCadastrar Contato:\n");
          System.out.print("Nome: ");
          String nome = scan.nextLine();
          System.out.print("E-Mail: ");
          String email = scan.nextLine().toLowerCase();
          System.out.print("Telefone: ");
          String telefone = scan.nextLine();
          System.out.print("Idade: ");
          int idade = Integer.parseInt(scan.nextLine());
          contatos[i] = new Contato(nome, idade, telefone, email);
          System.out.println("\nContato Cadastrado.\n");
          cheio = false;
          break; 
        }
      }
      
      if(cheio == true){
        System.out.println("\nAgenda já está cheia!\n");
      }  
  }
  
  public void pesquisarContato(){
   
    System.out.print("\nInforme o nome completo ou parte do nome: ");
    String nome = scan.nextLine();
    ordenarContatos(); 
    
    System.out.println("\nCONTATOS ENCONTRADOS\n");
    int quantidade = 0;
    for(int i = 0; i < contatos.length; i++){
      if((contatos[i] != null) && (contatos[i].getNome().toUpperCase().contains(nome.toUpperCase()))){
        quantidade++;
        System.out.println("Nome: " + contatos[i].getNome());
        System.out.println("E-Mail: " + contatos[i].getEmail());
        System.out.println("Telefone: " + contatos[i].getTelefone());
        System.out.println("Idade: " + contatos[i].getIdade() + "\n");
      }  
    }
    System.out.println(quantidade + " contatos encontrados.\n");
  } 
  public void ordenarContatos(){    
    for(int i = 0; i < contatos.length; i++){
      for(int j = 0; j < contatos.length; j++){
        if((contatos[i] != null) && (contatos[j] != null)){
          if(contatos[i].getNome().compareTo(contatos[j].getNome()) < 0){
            Contato temp = contatos[i];
            contatos[i] = contatos[j];
            contatos[j] = temp;
          }  
        }  
      }  
    }
  }
  
  public void excluirContato(){
    boolean encontrado = false;    
    System.out.print("\nInforme o nome completo do contato: ");
    String nome = scan.nextLine();   
    for(int i = 0; i < contatos.length; i++){
      if((contatos[i] != null) && (contatos[i].getNome().equalsIgnoreCase(nome))){
        contatos[i] = null; 
        System.out.println("\nExcluído com sucesso.\n");
        encontrado = true;
        break;
      }  
    } 
  }
}

