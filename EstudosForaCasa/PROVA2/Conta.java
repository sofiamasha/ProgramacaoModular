/*Exercício antes do polimorfismo (duas classes, um atributo em cada)

Classe Conta (atributo saldo, double)

Construtor que recebe o saldo inicial.
getSaldo(): devolve o saldo.
depositar(double valor): soma ao saldo, só se valor > 0. Não devolve nada.
sacar(double valor): subtrai, só se valor > 0 e valor <= saldo. Devolve true se conseguiu e false se não.
exibirSaldo(): imprime o saldo. Não devolve nada.

Classe ContaPoupanca extends Conta (atributo taxaRendimento, double, em %)

Construtor que recebe saldo e taxa, usando super.
rendimento(): devolve getSaldo() * taxaRendimento / 100.
aplicarRendimento(): deposita o rendimento no saldo. Não devolve nada. (Dica: ele pode reaproveitar métodos que já existem.)

Na Main, com Scanner:

Leia o saldo inicial e a taxa, e crie uma ContaPoupanca.
Leia um valor, deposite, e use exibirSaldo().
Leia outro valor e tente sacar. Com if sobre o boolean retornado, imprima “Saque realizado” ou “Saldo insuficiente”.
Imprima o rendimento(), chame aplicarRendimento() e use exibirSaldo() de novo.*/


public class Conta{
    private double saldo;
    
    public Conta(double saldo){
        this.saldo=saldo;
    }

    public double getSaldo(){
        return saldo;

    } 

    public void Depositar (double valor){
        if(valor>0){
          saldo+=valor;        }
        

    }

public boolean Sacar(double valor){
    if(valor>0 && valor<=saldo){
        saldo-=valor;
        return true;
    } else{return false;}

}

public void exibirSaldo(){
    System.out.println("Saldo: " + saldo);
}
}

public class ContaPoupanca extends Conta{
private double taxaRendimento;

public ContaPoupanca(double saldo, double taxaRendimento){
    super(saldo);
    this.taxaRendimento=taxaRendimento;
}
public double rendimento(){
    return getSaldo()*taxaRendimento/100;
}
public void aplicarRendimento(){
    depositar(rendimento());
}
}

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner (System.in);

        System.out.println("Digite seu valor inicial: ");
        double saldo =sc.nextDouble();

        System.out.println("Digite sua taxa: ");
        double taxaRendimento=sc.nextDouble();

        ContaPoupanca c=new ContaPoupanca(saldo,taxaRendimento);

        System.out.println("Digite um valor");
        double valor=sc.nextDouble();
        c.depositar(valor);

    

        c.exibirSaldo();

        System.out.println("Digite outro valor");
        double valor2=sc.nextDouble();

        if(c.Sacar(valor2)){
            System.out.println("Saque realizado");
        }
        else{
            System.out.println("Saldo insuficiente");


        }

        System.out.println("Rendimento: ", c.rendimento());

        c.aplicarRendimento();

        c.exibirSaldo;


    }
}