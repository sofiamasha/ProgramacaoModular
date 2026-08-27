import java.util.Scanner;

public class Loja {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        double[] preco = new double[10];
        int[] quantidade = new int[10];

        for(int i = 0; i < 10; i++){
            preco[i] = sc.nextDouble();
        }

        for(int i = 0; i < 10; i++){
            quantidade[i] = sc.nextInt();
        }

        double totalVendas = 0;

        int maiorQuantidade = quantidade[0];
        int posMaior = 0;

        for(int i = 0; i < 10; i++){

            double total = preco[i] * quantidade[i];

            System.out.println("Objeto " + (i + 1));
            System.out.println("Quantidade: " + quantidade[i]);
            System.out.println("Valor unitario: " + preco[i]);
            System.out.println("Valor total: " + total);

            totalVendas += total;

            if(quantidade[i] > maiorQuantidade){
                maiorQuantidade = quantidade[i];
                posMaior = i;
            }
        }

        double comissao = totalVendas * 0.05;

        System.out.println("Valor geral das vendas: " + totalVendas);
        System.out.println("Valor da comissao: " + comissao);

        System.out.println("Objeto mais vendido: " + (posMaior + 1));
        System.out.println("Posicao no vetor: " + posMaior);

        sc.close();
    }
}