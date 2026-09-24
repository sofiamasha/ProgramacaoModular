package Pratica2.Parte2;
import java.util.HashMap;

public class Estoque {

    private HashMap<Integer, Produto> produtos;
    private int tamanho;

    public Estoque() {
        produtos = new HashMap<Integer, Produto>();
        tamanho = 0;
    }

    public HashMap<Integer, Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(HashMap<Integer, Produto> produtos) {
        this.produtos = produtos;
        tamanho = produtos.size();
    }

    public int getTamanho() {
        return tamanho;
    }

    public boolean adicionarProduto(Produto produto) {

        boolean adicionou = false;

        if (!produtos.containsKey(produto.getCodigo())) {
            produtos.put(produto.getCodigo(), produto);
            tamanho++;
            adicionou = true;
        }

        return adicionou;
    }

    public Produto buscarProduto(int codigo) {

        Produto produto = null;

        if (produtos.containsKey(codigo)) {
            produto = produtos.get(codigo);
        }

        return produto;
    }

    public boolean removerProduto(int codigo) {

        boolean removeu = false;

        if (produtos.containsKey(codigo)) {
            produtos.remove(codigo);
            tamanho--;
            removeu = true;
        }

        return removeu;
    }

    public boolean verificarExistencia(int codigo) {

        boolean existe = false;

        if (produtos.containsKey(codigo)) {
            existe = true;
        }

        return existe;
    }

    public void listarProdutos() {

        for (Integer codigo : produtos.keySet()) {

            Produto produto = produtos.get(codigo);

            System.out.println("Codigo: " + produto.getCodigo());
            System.out.println("Nome: " + produto.getNome());
            System.out.printf("Preco: R$ %.2f%n", produto.getPreco());
            System.out.println("Quantidade em estoque: "
                    + produto.getQuantidadeEstoque());
            System.out.println();
        }
    }
}