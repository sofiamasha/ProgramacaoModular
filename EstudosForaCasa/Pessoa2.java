public class Pessoa2 {
    private String nome;
    private int idade;

    public Pessoa2() {
        this.idade = 0;
        this.nome = " ";
    }

    public Pessoa2(int idade, String nome) {
        this.nome = nome;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public void apresentar() {
        System.out.println("Nome: " + nome);
        System.out.println("Idade: " + idade);
    }
}