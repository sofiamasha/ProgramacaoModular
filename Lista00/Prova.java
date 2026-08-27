import java.util.Scanner;

public class Prova {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        char[] gabarito = new char[8];

        for(int i = 0; i < 8; i++){
            gabarito[i] = sc.next().charAt(0);
        }

        int aprovados = 0;

        for(int aluno = 0; aluno < 10; aluno++){

            int numero = sc.nextInt();
            int nota = 0;

            for(int i = 0; i < 8; i++){

                char resposta = sc.next().charAt(0);

                if(resposta == gabarito[i]){
                    nota++;
                }
            }

            System.out.println("Aluno: " + numero);
            System.out.println("Nota: " + nota);

            if(nota >= 6){
                aprovados++;
            }
        }

        double porcentagem = aprovados * 100.0 / 10;

        System.out.println("Porcentagem de aprovacao: " + porcentagem + "%");

        sc.close();
    }
}