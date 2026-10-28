import java.util.*;
public interface Avaliavel{
    double getNotaMedia();
}
public interface Notificavel{
    void notificar(String mensagem);
}

public class Atividade{
    private String titulo;

    public Atividade(String titulo){
        this.titulo=titulo;
    }
    public String getTitulo(){
        return titulo;
    }
}

public class Oficina extends Atividade implements Avaliavel, Notificavel{
    private double nota;

    public Oficina(String titulo, double nota){
        super(titulo);
        this.nota=nota;
    }

    public double getNotaMedia(){
        return nota;
    }

    public void notificar(String mensagem){
        System.out.println("Oficina :"+ getTitulo() + ":" + mensagem);
    }
}

public class Palestra extends Atividade implements Avaliavel{
    private double nota;

    public Palestra(String titulo, double nota){
        super(titulo);
        this.nota=nota;
    }

    public double getNotaMedia(){
        return nota;
    }
}

public class Restaurante implements Avaliavel{
    private String nome;
    private double nota;

    public Restaurante(String nome, double nota){
        this.nome=nome;
        this.nota=nota;
    }

    public double getNotaMedia(){
        return nota;
    }
}

public class Main{
    public static void main(String[] args){
        ArrayList<Avaliavel> a=new ArrayList<>();

        a.add(new Oficina("Java", 9));
        a.add(new Palestra("IA", 8));
        a.add(new Restaurante("Sabor",7));
  double total=0;
        for(Avaliavel av : a){
System.out.println("Notas: " + av.getNotaMedia());
          
            total+=av.getNotaMedia();
           

        }
         System.out.println("Média geral: " + total / a.size());

        ArrayList<Atividade> aa=new ArrayList<>();

        aa.add(new Oficina("C",3));
        aa.add(new Palestra("AFF", 2));

        for(Atividade aaa: aa){
            if(aaa instanceof Notificavel){
                Notificavel no = (Notificavel ) aaa;
                no.notificar("Notificar amanha");
            }
        }
    }
}