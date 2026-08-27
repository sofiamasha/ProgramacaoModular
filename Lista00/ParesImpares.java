
public import java.util.Scanner;

public class ParesImpares {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[] v = new int[6];

        int somaPares = 0;
        int quantidadeImpares = 0;

        for(int i = 0; i < 6; i++){
            v[i] = sc.nextInt();
        }

        System.out.println("Os numeros pares sao:");

        for(int i = 0; i < 6; i++){

            if(v[i] % 2 == 0){
                System.out.println("numero " + v[i] +
                                   " na posicao " + (i + 1));

                somaPares += v[i];
            }
        }

        System.out.println("Soma dos pares = " + somaPares);

        System.out.println("Os numeros impares sao:");

        for(int i = 0; i < 6; i++){

            if(v[i] % 2 != 0){
                System.out.println("numero " + v[i] +
                                   " na posicao " + (i + 1));

                quantidadeImpares++;
            }
        }

        System.out.println("Quantidade de impares = " +
                           quantidadeImpares);

        sc.close();
    }
} {
    
}
