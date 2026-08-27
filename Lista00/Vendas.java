import java.util.Scanner;

public class Vendas {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        double[][] vendas = new double[12][4];

        for(int i = 0; i < 12; i++){

            for(int j = 0; j < 4; j++){
                vendas[i][j] = sc.nextDouble();
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

        double totalAno = 0;

        for(int i = 0; i < 12; i++){

            double totalMes = 0;

            for(int j = 0; j < 4; j++){
                totalMes += vendas[i][j];
            }

            System.out.println("Total de " + meses[i] +
                               ": " + totalMes);

            totalAno += totalMes;
        }

        for(int j = 0; j < 4; j++){

            double totalSemana = 0;

            for(int i = 0; i < 12; i++){
                totalSemana += vendas[i][j];
            }

            System.out.println("Total da semana " +
                               (j + 1) + ": " + totalSemana);
        }

        System.out.println("Total vendido no ano: " + totalAno);

        sc.close();
    }
}