public enum Tamanho{
    PEQUENO(10.0), MEDIO(15.0), GRANDE(20.0);

    private double preco;
    public Tamanho(double preco){
        this.preco=preco;
    }
    public double getPreco(){
        return preco;
    }
}


public class Main{
    public static void main(String [] args){
       Tamanho t = new Tamanho();
       /*Consigo fzr uma lista?:
       ArrayList<Tamanho> t = new ArrayList<>();
       t.add(Tamanho(PEQUENO));
       
       */
        for(Tamanho tam: Tamanho.values()){
        System.out.println(tam + " - " + tam.getPreco() + " - " + tam.ordinal());
        }

         Tamanho ta=Tamanho.valueOf("MEDIO");
        System.out.println("Preco: " + ta.getPreco());
    }
}