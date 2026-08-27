
import java.util.Scanner;

public class Uniao {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n;
        int m;

        n = sc.nextInt();
        m = sc.nextInt();

        int[] x = new int[n];
        int[] y = new int[m];
        int[] z = new int[n + m];

        for(int i = 0; i < n; i++){
            x[i] = sc.nextInt();
        }

        for(int i = 0; i < m; i++){
            y[i] = sc.nextInt();
        }

        int cont = 0;

        for(int i = 0; i < n; i++){
            z[cont] = x[i];
            cont++;
        }

        for(int i = 0; i < m; i++){

            int encontrou = 0;

            for(int j = 0; j < cont; j++){

                if(y[i] == z[j]){
                    encontrou = 1;
                    break;
                }
            }

            if(encontrou == 0){
                z[cont] = y[i];
                cont++;
            }
        }

        for(int i = 0; i < cont; i++){
            System.out.println(z[i]);
        }

        sc.close();
    }
}