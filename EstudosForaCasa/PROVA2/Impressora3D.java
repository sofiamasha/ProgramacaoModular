public class abstract Equipamento{
//classe que possui um metodo abstrato pode ser abstract
//abstrata define os metodos que as filhas DEVEM ter

    protected int codigo;
    protected String descricao;
    //atributos que as filhas conseguem acessar

    public abstract void executarOperacao(); //sem corpo
    //eu tenho ess funcoa e cad um pode executar do jeito que achar melhor 
    //nao implemento, qm implementa eh a filha

    public void exibirDescricao(){ //com corpo
        System.out.println(descricao);
    }
}

//impressora precisa imprimir e scanner precisa scannear
//as duas herdam de equipamento mas implementa a propria operacao

public class Impressora3D extends Equipamento{

    @Override
    //estou sobrescrevendo um metodo que veio da mae 

    public void executarOperacao(){
        System.out.println("Imprimindo em 3d");
    }
}

public class Scanner3d extends Equipamento{

    @Override

    public void executarOperacao(){
        System.out.println("Escaneando objeto");
    }
}

/*SOBRESCRITA:
As duas classes herdaram de equipamento, pegaram o metodo abstrado
e imprimiram do jeito que ELAS precisavam

Usando OVERRIDE

Sobrescrita é quando uma subclasse redefine o metodo herdado,
tem o metodo herdado mas ela faz do jeito dela

mantem a assinatura da subclasse mas com a propria implementacao
*/

public class Calibravel{
    public void Calibrar();
}
public class Impressora3d extends Equipamento implements calibravel{

}
//implements serve para as classes q querem ter tal comportamente puxarem-o