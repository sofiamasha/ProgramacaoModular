package Pratica2.Parte2;
import java.util.ArrayList;

public class Fatura {

    private ArrayList<Item> itens;
    private double valorTotal;

    public Fatura() {
        itens = new ArrayList<Item>();
        valorTotal = 0;
    }

    public ArrayList<Item> getItens() {
        return itens;
    }

    public void setItens(ArrayList<Item> itens) {
        this.itens = itens;
        calcularValorTotal();
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public void incluirItem(Item item) {
        itens.add(item);
        calcularValorTotal();
    }

    public void excluirItem(int posicao) {
        itens.remove(posicao);
        calcularValorTotal();
    }

    public void alterarItem(int posicao, int quantidade) {
        itens.get(posicao).realizarCompra(quantidade);
        calcularValorTotal();
    }

    public void calcularValorTotal() {

        valorTotal = 0;

        for (int i = 0; i < itens.size(); i++) {
            valorTotal = valorTotal + itens.get(i).getValorTotal();
        }
    }
}