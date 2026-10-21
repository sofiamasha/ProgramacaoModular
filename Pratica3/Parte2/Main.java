import java.util.Scanner;

public class Main {

    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        Bilheteria bil=new Bilheteria();
        int opcao=0;

        while (opcao!=7)
        {
            System.out.println("\n=== SISTEMA DE INGRESSOS ===");
            System.out.println("1 - Cadastrar ingresso");
            System.out.println("2 - Remover ingresso");
            System.out.println("3 - Buscar ingresso por codigo");
            System.out.println("4 - Listar todos os ingressos");
            System.out.println("5 - Calcular arrecadacao total");
            System.out.println("6 - Listar beneficios");
            System.out.println("7 - Sair");
            System.out.print("Opcao: ");
            opcao=sc.nextInt();
            sc.nextLine();

            switch (opcao)
            {
                case 1:
                    System.out.println("Tipo: 1-Comum  2-Estudante  3-VIP");
                    int tipo=sc.nextInt(); sc.nextLine();

                    System.out.print("Codigo: ");     int cod=sc.nextInt(); sc.nextLine();
                    System.out.print("Evento: ");     String ev=sc.nextLine();
                    System.out.print("Setor: ");      String set=sc.nextLine();
                    System.out.print("Valor base: "); double val=sc.nextDouble(); sc.nextLine();

                    if (tipo==1)
                    {
                        bil.adicionarIngresso(new IngressoComum(cod, ev, set, val));
                    }
                    else if (tipo==2)
                    {
                        System.out.print("Instituicao de ensino: ");
                        String inst=sc.nextLine();
                        bil.adicionarIngresso(new IngressoEstudante(cod, ev, set, val, inst));
                    }
                    else
                    {
                        System.out.print("Acesso ao backstage? (true/false): ");
                        boolean back=sc.nextBoolean(); sc.nextLine();
                        System.out.print("Numero do lounge: ");
                        int lounge=sc.nextInt(); sc.nextLine();
                        bil.adicionarIngresso(new IngressoVIP(cod, ev, set, val, back, lounge));
                    }
                    break;

                case 2:
                    System.out.print("Codigo do ingresso: ");
                    bil.removerIngresso(sc.nextInt()); sc.nextLine();
                    break;

                case 3:
                    System.out.print("Codigo do ingresso: ");
                    Ingresso encontrado=bil.buscarIngresso(sc.nextInt()); sc.nextLine();
                    if (encontrado!=null)
                    {
                        System.out.println("-------------------");
                        encontrado.exibir();
                    }
                    else
                    {
                        System.out.println("Ingresso nao encontrado.");
                    }
                    break;

                case 4:
                    bil.listarIngressos();
                    break;

                case 5:
                    System.out.printf("Arrecadacao total: R$ %.2f%n", bil.calcularArrecadacaoTotal());
                    break;

                case 6:
                    bil.listarBeneficios();
                    break;

                case 7:
                    System.out.println("Encerrando...");
                    break;

                default:
                    System.out.println("Opcao invalida.");
            }
        }
        sc.close();
    }
}