package Pratica2.Parte2;
public class Produto {

    private String nome;
    private int codigo;
    private double preco;
    private int quantidadeEstoque;

    public Produto(String nome, int codigo, double preco) {
        this.nome = nome;
        this.codigo = codigo;
        this.preco = preco;
        this.quantidadeEstoque = 0;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(int quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public void adicionarEstoque(int quantidade) {
        quantidadeEstoque = quantidadeEstoque + quantidade;
    }

    public boolean retirarEstoque(int quantidade) {

        boolean conseguiuRetirar = false;

        if (quantidade <= quantidadeEstoque) {
            quantidadeEstoque = quantidadeEstoque - quantidade;
            conseguiuRetirar = true;
        }

        return conseguiuRetirar;
    }
}