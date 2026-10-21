import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Agenda agenda=new Agenda();
        int opcao=0;

        while (opcao != 7) {
            System.out.println("\n=== AGENDA TELEFÔNICA ===");
            System.out.println("1 - Adicionar contato");
            System.out.println("2 - Remover contato");
            System.out.println("3 - Buscar por nome");
            System.out.println("4 - Buscar por email");
            System.out.println("5 - Buscar por telefone");
            System.out.println("6 - Tamanho da agenda");
            System.out.println("7 - Sair");
            System.out.print("Opção: ");
            opcao = sc.nextInt();
            sc.nextLine(); // limpa o buffer

            switch (opcao) {

                case 1:
                    System.out.println("Tipo: 1-Pessoal  2-Profissional  3-Emergência");
                    int tipo = sc.nextInt(); sc.nextLine();

                    System.out.print("Nome: ");      String nome  = sc.nextLine();
                    System.out.print("Email: ");     String email = sc.nextLine();
                    System.out.print("Telefone: ");  String tel   = sc.nextLine();

                    if (tipo == 1) {
                        System.out.print("Aniversário: "); String aniv = sc.nextLine();
                        System.out.print("Parentesco: ");  String par  = sc.nextLine();
                        agenda.adicionarContato(new ContatoPessoal(nome, email, tel, aniv, par));

                    } else if (tipo == 2) {
                        System.out.print("Empresa: "); String emp   = sc.nextLine();
                        System.out.print("Cargo: ");   String cargo = sc.nextLine();
                        agenda.adicionarContato(new ContatoProfissional(nome, email, tel, emp, cargo));

                    } else {
                        System.out.print("Prioridade (1-5): "); int prior = sc.nextInt(); sc.nextLine();
                        System.out.print("Observação: ");       String obs = sc.nextLine();
                        agenda.adicionarContato(new ContatoEmergencia(nome, email, tel, prior, obs));
                    }
                    break;

                case 2:
                    System.out.print("Nome para remover: ");
                    agenda.removerContato(sc.nextLine());
                    break;

                case 3:
                    System.out.print("Nome: ");
                    Contato c3 = agenda.buscarPorNome(sc.nextLine());
                    if (c3 != null) c3.exibir();
                    else System.out.println("Contato não encontrado.");
                    break;

                case 4:
                    System.out.print("Email: ");
                    Contato c4 = agenda.buscarPorEmail(sc.nextLine());
                    if (c4 != null) c4.exibir();
                    else System.out.println("Contato não encontrado.");
                    break;

                case 5:
                    System.out.print("Telefone: ");
                    Contato c5 = agenda.buscarPorTelefone(sc.nextLine());
                    if (c5 != null) c5.exibir();
                    else System.out.println("Contato não encontrado.");
                    break;

                case 6:
                    System.out.println("Total de contatos: " + agenda.getTamanho());
                    break;

                case 7:
                    System.out.println("Encerrando...");
                    break;

                default:
                    System.out.println("Opção inválida.");
            }
        }
        sc.close();
    }
}