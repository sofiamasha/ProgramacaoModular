import java.uttil.Scanner;

public class LeituraValor{
    public static void main(String [] args){
        Scanner sc=new Scanner(System.in);

        int v[]  = new int[2];

        for(int i=0; i<=2; i++){
            v[i]=sc.nextInt();
        }

        int maior=v[0];

        for(int i=0; i<=2; i++){
            if(v[i]>maior){
                maior=v[i];
            }


        }
        System.out.println(maior);

        int menor=v[0];

        for(int i=0; i<=2; i++){
            if(v[i]<menor){
                menor=v[i];
            }
        }
        System.out.println(menor);


        if((x>=y && x<=z) || (x<=y && x>=z)){
            System.out.println("x esta entre y e z");
        
        }
        else{
            System.out.println("x nao esta entre y e z");
        }


    if(x%y==0 && x%z==0){
        System.out.println("x é divisivel por y e z");
    }
    else{
        System.out.println("x nao e divisivel");
    }
    }
}