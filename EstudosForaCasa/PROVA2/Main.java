
import java.util.*;

abstract class Veiculo {
    private String placa;
    private String modelo;

    public Veiculo(String placa, String modelo) {
        this.placa = placa;
        this.modelo = modelo;
    }

    public String getPlaca() {
        return placa;
    }

    public String getModelo() {
        return modelo;
    }

    public abstract void realizarEntrega();

    public void exibirInformacoes() {
        System.out.println("Placa: " + placa);
        System.out.println("Modelo: " + modelo);
    }

    public void registrarEntrega() {
        System.out.println("Registrado");
    }

    public void registrarEntrega(String destino) {
        System.out.println("Entrega em: " + destino + " registrada");
    }
}

interface Gps {
    void rastrearVeiculo();
}

class Moto extends Veiculo {

    public Moto(String placa, String modelo) {
        super(placa, modelo);
    }

    @Override
    public void realizarEntrega() {
        System.out.println("Entregando com a moto...");
    }
}

class Drone extends Veiculo implements Gps {

    public Drone(String placa, String modelo) {
        super(placa, modelo);
    }

    @Override
    public void realizarEntrega() {
        System.out.println("Entregando com o drone!");
    }

    @Override
    public void rastrearVeiculo() {
        System.out.println("Rastreando...");
    }
}

class Caminhao extends Veiculo {

    public Caminhao(String placa, String modelo) {
        super(placa, modelo);
    }

    @Override
    public void realizarEntrega() {
        System.out.println("Entregando com o caminhao!");
    }
}

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);


        ArrayList<Veiculo> veiculos=new ArrayList<>();

        veiculos.add(new Moto("123", "suv"));
        veiculos.add(new Caminhao("345", "honda"));

        Iterator<Veiculo> it=veiculos.iterator();


        while(it.hasNext()){
            Veiculo v=it.next();
            v.realizarEntrega();
        }

        Veiculo moto = new Moto("12344", "Honda");
        Veiculo drone = new Drone("10192", "Bansai");
        Veiculo caminhao = new Caminhao("67676", "Palio");

        System.out.println("=== MOTO ===");
        moto.exibirInformacoes();
        moto.realizarEntrega();

        System.out.println("\n=== DRONE ===");
        drone.exibirInformacoes();
        drone.realizarEntrega();

        Gps gps = (Gps) drone;
        gps.rastrearVeiculo();

        System.out.println("\n=== CAMINHAO ===");
        caminhao.exibirInformacoes();
        caminhao.realizarEntrega();

        caminhao.registrarEntrega();

        System.out.print("Informe o destino: ");
        String destino = sc.nextLine();

        caminhao.registrarEntrega(destino);

        sc.close();
    }
}
