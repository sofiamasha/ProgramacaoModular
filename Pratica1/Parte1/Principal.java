import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Leitura dos dados da pessoa
        System.out.print("Digite o nome: ");
        String nome = scanner.nextLine();

        System.out.print("Digite o sobrenome: ");
        String sobrenome = scanner.nextLine();

        System.out.print("Digite a idade: ");
        int idade = scanner.nextInt();

        System.out.print("Digite a altura (ex: 1,75): ");
        double altura = scanner.nextDouble();

        System.out.print("Digite o peso em kg (ex: 70,5): ");
        double peso = scanner.nextDouble();

        // Criando o objeto da classe Pessoa
        Pessoa pessoa = new Pessoa(nome, sobrenome, idade, altura, peso);

        // Calculando o IMC
        double imcCalculado = pessoa.calculaIMC();

        // Obtendo a classificação
        String classificacao = pessoa.informaObesidade();

        // Exibindo os resultados
        System.out.println("\n--- RESULTADO ---");
        System.out.println("Pessoa: " + pessoa.getNome() + " " + pessoa.getSobrenome());
        System.out.printf("IMC: %.2f\n", imcCalculado);
        System.out.println("Classificação: " + classificacao);

        scanner.close();
    }
}