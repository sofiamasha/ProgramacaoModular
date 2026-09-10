import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            System.out.println("=====================================");
            System.out.println("   CHAPÉU SELETOR DE HOGWARTS");
            System.out.println("=====================================");

            System.out.print("Digite o nome do aluno: ");
            String nome = scanner.nextLine();

            System.out.print("Digite a idade: ");
            int idade = scanner.nextInt();

            System.out.print("Digite a nota de Coragem (0 a 10): ");
            double coragem = scanner.nextDouble();

            System.out.print("Digite a nota de Inteligência (0 a 10): ");
            double inteligencia = scanner.nextDouble();

            System.out.print("Digite a nota de Ambição (0 a 10): ");
            double ambicao = scanner.nextDouble();

            System.out.print("Digite a nota de Lealdade (0 a 10): ");
            double lealdade = scanner.nextDouble();

            System.out.print("Digite a nota de Estratégia (0 a 10): ");
            double estrategia = scanner.nextDouble();

            System.out.print("Digite a nota de Criatividade (0 a 10): ");
            double criatividade = scanner.nextDouble();

            // Instancia a classe Aluno
            Aluno aluno = new Aluno(nome, idade, coragem, inteligencia, ambicao, lealdade, estrategia, criatividade);

            // Calcula a casa baseando-se nas pontuações
            aluno.calcularCasa();

            // Exibe o resultado da seleção
            aluno.exibirInformacoes();

            // Limpa o buffer do teclado antes da próxima leitura de String
            scanner.nextLine();

            // Pergunta ao usuário se ele quer cadastrar outro aluno
            System.out.print("Deseja selecionar outro aluno? (S/N): ");
            String resposta = scanner.nextLine();

            if (resposta.equalsIgnoreCase("N")) {
                continuar = false;
                System.out.println("Encerrando a Seleção de Hogwarts. Até logo!");
            }
        }

        scanner.close();
    }
}