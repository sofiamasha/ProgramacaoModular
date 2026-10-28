import java.util.*;
public abstract class Veiculo{

    private String placa;
    private String modelo;

    public Veiculo(String placa, String modelo){
        this.placa=placa;
        this.modelo=modelo;
    }

    public String getPlaca(){
        return placa;
    }
    public String getModelo(){
        return modelo;
    }

    public abstract void ExibirInformacoes(){
        System.out.println("Placa: " + placa);
        System.out.println("Modelo: " + modelo);
    }
    public abstract void RealizarEntrega();
}

public interface Gps{
        public void RastrearEntrega();
}

public class Caminhao extends Veiculo{

}
public class Moto extends Veiculo{

}
public class Drone extends Veiculo implements Gps{

}