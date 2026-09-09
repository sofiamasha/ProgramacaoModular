public class Main{
    public void static main(String [] agrs){
        Pessoa pessoa1=new Pessoa("Joao", 25, 1.34);
        System.out.println("Nome: " + pessoa1.getNome());
        System.out.println("Idade: " +pessoa1.getIdade());
        System.out.println("Altura: " + pessoa1.getAltura());

    }
}