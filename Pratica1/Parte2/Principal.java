import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        Aluno[] alunos = new Aluno[10];

        int quantidadeAlunos = 0;

        int opcao = 0;

        while (opcao != 8) {

            System.out.println("\n===== SISTEMA DE HOGWARTS =====");
            System.out.println("1. Cadastrar aluno");
            System.out.println("2. Listar todos os alunos");
            System.out.println("3. Exibir alunos de uma determinada casa");
            System.out.println("4. Exibir alunos por casa");
            System.out.println("5. Exibir alunos maiores de idade");
            System.out.println("6. Exibir alunos menores de idade");
            System.out.println("7. Buscar alunos por sobrenome");
            System.out.println("8. Encerrar");
            System.out.print("Escolha uma opção: ");

            opcao = entrada.nextInt();
            entrada.nextLine();

            switch (opcao) {

                // =====================================
                // 1 - CADASTRAR ALUNO
                // =====================================
                case 1:

                    if (quantidadeAlunos == 10) {

                        System.out.println("Limite máximo de 10 alunos atingido.");

                    } else {

                        System.out.println("\n--- CADASTRO DE ALUNO ---");

                        System.out.print("Nome: ");
                        String nome = entrada.nextLine();

                        System.out.print("Sobrenome: ");
                        String sobrenome = entrada.nextLine();

                        System.out.print("Data de nascimento (dd/MM/yyyy): ");
                        String data = entrada.nextLine();

                        LocalDate dataNascimento;

                        try {

                            dataNascimento = LocalDate.parse(data, formato);

                        } catch (Exception e) {

                            System.out.println("Data inválida. Cadastro cancelado.");
                            break;
                        }

                        System.out.print("Coragem: ");
                        double coragem = entrada.nextDouble();

                        System.out.print("Inteligência: ");
                        double inteligencia = entrada.nextDouble();

                        System.out.print("Ambição: ");
                        double ambicao = entrada.nextDouble();

                        System.out.print("Lealdade: ");
                        double lealdade = entrada.nextDouble();

                        System.out.print("Estratégia: ");
                        double estrategia = entrada.nextDouble();

                        System.out.print("Criatividade: ");
                        double criatividade = entrada.nextDouble();

                        entrada.nextLine();

                        // Cria o objeto Aluno
                        Aluno aluno = new Aluno(
                                nome,
                                sobrenome,
                                dataNascimento,
                                coragem,
                                inteligencia,
                                ambicao,
                                lealdade,
                                estrategia,
                                criatividade
                        );

                        // Calcula a casa
                        aluno.calcularCasa();

                        // Gera a matrícula usando a posição no vetor
                        aluno.gerarCodigoMatricula(quantidadeAlunos);

                        // Guarda o aluno no vetor
                        alunos[quantidadeAlunos] = aluno;

                        // Aumenta a quantidade de alunos
                        quantidadeAlunos++;

                        System.out.println("\nAluno cadastrado com sucesso!");
                        System.out.println("Casa: " + aluno.formatarCasa());
                        System.out.println("Usuário: " + aluno.gerarNomeUsuario());
                        System.out.println("Matrícula: " + aluno.getCodigoMatricula());
                    }

                    break;

                // =====================================
                // 2 - LISTAR TODOS
                // =====================================
                case 2:

                    if (quantidadeAlunos == 0) {

                        System.out.println("\nNenhum aluno cadastrado.");

                    } else {

                        System.out.println("\n===== TODOS OS ALUNOS =====");

                        for (int i = 0; i < quantidadeAlunos; i++) {

                            alunos[i].exibirInformacoes();
                        }
                    }

                    break;

                // =====================================
                // 3 - ALUNOS DE UMA CASA
                // =====================================
                case 3:

                    if (quantidadeAlunos == 0) {

                        System.out.println("\nNenhum aluno cadastrado.");

                    } else {

                        System.out.print("\nDigite a casa: ");
                        String casaInformada = entrada.nextLine();

                        int totalCasa = 0;

                        System.out.println("\n--- ALUNOS DA CASA ---");

                        for (int i = 0; i < quantidadeAlunos; i++) {

                            if (alunos[i].verificarCasa(casaInformada)) {

                                alunos[i].exibirInformacoes();

                                totalCasa++;
                            }
                        }

                        System.out.println("Total de alunos da casa: " + totalCasa);
                    }

                    break;

                // =====================================
                // 4 - ALUNOS POR CASA
                // =====================================
                case 4:

                    if (quantidadeAlunos == 0) {

                        System.out.println("\nNenhum aluno cadastrado.");

                    } else {

                        System.out.println("\n===== GRIFINÓRIA =====");

                        for (int i = 0; i < quantidadeAlunos; i++) {

                            if (alunos[i].verificarCasa("Grifinória")) {

                                alunos[i].exibirInformacoes();
                            }
                        }

                        System.out.println("\n===== SONSERINA =====");

                        for (int i = 0; i < quantidadeAlunos; i++) {

                            if (alunos[i].verificarCasa("Sonserina")) {

                                alunos[i].exibirInformacoes();
                            }
                        }

                        System.out.println("\n===== CORVINAL =====");

                        for (int i = 0; i < quantidadeAlunos; i++) {

                            if (alunos[i].verificarCasa("Corvinal")) {

                                alunos[i].exibirInformacoes();
                            }
                        }

                        System.out.println("\n===== LUFA-LUFA =====");

                        for (int i = 0; i < quantidadeAlunos; i++) {

                            if (alunos[i].verificarCasa("Lufa-Lufa")) {

                                alunos[i].exibirInformacoes();
                            }
                        }
                    }

                    break;

                // =====================================
                // 5 - MAIORES DE IDADE
                // =====================================
                case 5:

                    if (quantidadeAlunos == 0) {

                        System.out.println("\nNenhum aluno cadastrado.");

                    } else {

                        System.out.println("\n===== ALUNOS MAIORES DE IDADE =====");

                        for (int i = 0; i < quantidadeAlunos; i++) {

                            if (alunos[i].verificarMaioridadeMagica()) {

                                alunos[i].exibirInformacoes();
                            }
                        }
                    }

                    break;

                // =====================================
                // 6 - MENORES DE IDADE
                // =====================================
                case 6:

                    if (quantidadeAlunos == 0) {

                        System.out.println("\nNenhum aluno cadastrado.");

                    } else {

                        System.out.println("\n===== ALUNOS MENORES DE IDADE =====");

                        for (int i = 0; i < quantidadeAlunos; i++) {

                            if (!alunos[i].verificarMaioridadeMagica()) {

                                alunos[i].exibirInformacoes();
                            }
                        }
                    }

                    break;

                // =====================================
                // 7 - BUSCAR SOBRENOME
                // =====================================
                case 7:

                    if (quantidadeAlunos == 0) {

                        System.out.println("\nNenhum aluno cadastrado.");

                    } else {

                        System.out.print("\nDigite parte do sobrenome: ");
                        String palavra = entrada.nextLine();

                        boolean encontrou = false;

                        System.out.println("\n===== RESULTADO DA BUSCA =====");

                        for (int i = 0; i < quantidadeAlunos; i++) {

                            if (alunos[i].verificarPalavra(palavra)) {

                                alunos[i].exibirInformacoes();

                                encontrou = true;
                            }
                        }

                        if (!encontrou) {

                            System.out.println("Nenhum aluno encontrado.");
                        }
                    }

                    break;

                // =====================================
                // 8 - ENCERRAR
                // =====================================
                case 8:

                    System.out.println("\nSistema encerrado.");

                    break;

                default:

                    System.out.println("\nOpção inválida.");
            }
        }

        // Ao finalizar, exibe todos os alunos cadastrados
        if (quantidadeAlunos > 0) {

            System.out.println("\n===== DADOS DOS ALUNOS CADASTRADOS =====");

            for (int i = 0; i < quantidadeAlunos; i++) {

                alunos[i].exibirInformacoes();
            }
        }

        entrada.close();
    }
}