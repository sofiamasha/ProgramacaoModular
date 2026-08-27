
import java.util.Scanner;

public class Intersecao {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n;
        sc.nextInt();

        int[] v1 = new int[n];
        int[] v2 = new int[n];

        for(int i = 0; i < n; i++){
            v1[i] = sc.nextInt();
        }

        for(int i = 0; i < n; i++){
            v2[i] = sc.nextInt();
        }

        for(int i = 0; i < n; i++){

            for(int j = 0; j < n; j++){

                if(v1[i] == v2[j]){
                    System.out.println(v1[i]);
                }

            }

        }

        sc.close();
    }
}