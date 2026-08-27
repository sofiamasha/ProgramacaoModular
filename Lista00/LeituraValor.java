
import java.util.Scanner;

public class LeituraValor {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[] v = new int[3];

        for(int i = 0; i < 3; i++){
            v[i] = sc.nextInt();
        }

        int maior = v[0];

        for(int i = 1; i < 3; i++){
            if(v[i] > maior){
                maior = v[i];
            }
        }

        System.out.println(maior);

        int menor = v[0];

        for(int i = 1; i < 3; i++){
            if(v[i] < menor){
                menor = v[i];
            }
        }

        System.out.println(menor);

        if((v[0] >= v[1] && v[0] <= v[2]) ||
           (v[0] <= v[1] && v[0] >= v[2])){
            System.out.println("x esta entre y e z");
        }
        else{
            System.out.println("x nao esta entre y e z");
        }

        if(v[0] % v[1] == 0 && v[0] % v[2] == 0){
            System.out.println("x e divisivel por y e z");
        }
        else{
            System.out.println("x nao e divisivel por y e z");
        }

        sc.close();
    }
}