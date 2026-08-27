import java.util.Scanner;

public class Temperatura {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        double[] temperatura = new double[12];

        for(int i = 0; i < 12; i++){
            temperatura[i] = sc.nextDouble();
        }

        double maior = temperatura[0];
        double menor = temperatura[0];

        int posMaior = 0;
        int posMenor = 0;

        for(int i = 1; i < 12; i++){

            if(temperatura[i] > maior){
                maior = temperatura[i];
                posMaior = i;
            }

            if(temperatura[i] < menor){
                menor = temperatura[i];
                posMenor = i;
            }
        }

        String[] meses = {
            "janeiro",
            "fevereiro",
            "marco",
            "abril",
            "maio",
            "junho",
            "julho",
            "agosto",
            "setembro",
            "outubro",
            "novembro",
            "dezembro"
        };

        System.out.println("Maior temperatura: " + maior);
        System.out.println("Mes: " + meses[posMaior]);

        System.out.println("Menor temperatura: " + menor);
        System.out.println("Mes: " + meses[posMenor]);

        sc.close();
    }
}