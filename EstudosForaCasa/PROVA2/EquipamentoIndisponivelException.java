
try{
    int divisao=a/b;
    System.out.println("Valor: " + divisao);
}catch(ArithmeticException e){
    System.out.println("Divisao por zero: " + e.getMessage());
}
System.out.println("FIM");


public void sacar(double valor)
    throws Exception{
        if(valor>saldo){
            throw new Exception ("Saldo insuficiente ");
        }
        saldo=saldo-valor;
    }


public void Equipamento(double saldo){
    throws Exception{
        if(saldo==null){
            throw new Exception("Indisponivel");
        }
    }
}

public void sacar(double valor) throws Exception {

    if (valor > saldo) {
        throw new Exception("Saldo insuficiente");
    }

    saldo = saldo - valor;
}



try {
    equipamento.emprestrar();

}
catch (Exception e){
    System.out.println(e.getMessage());
}



public class EquipamentoIndisponivelException extends Exception{

    public EquipamentoIndisponivelException (String mensagem){
        super(mensagem)
    }
}


public void emprestar()
    throws EquipamentoIndisponivelException{
        if(!disponivel){
            throw new EquipamentoIndisponivelException("Equipamento indisponivel");
        }
        System.out.println("Emprestimo realizado!");
    }


try {
    equipamento.emprestrar();
}
catch (EquipamentoIndisponivelException e){
    System.out.println(e.getMessage());
}


public class SaldoInsuficienteException extends Exception{
    public SaldoInsuficienteException(String mensagem){
        super(mensagem);
    }
}

public void Sacar(double valor)
    throws Exception{
        if(valor>saldo){
            throw SaldoInsuficienteException("Saldo insuficiente");
        }
        saldo=saldo-valor;
    }

public class Main{
    public static void main(String[] args){
        Equipamento e=new Equipamento();
        try {
            e.Sacar(500);
        }
        catch(SaldoInsuficienteException erro){
            System.out.println(e.getMessage());
        }


    }
}