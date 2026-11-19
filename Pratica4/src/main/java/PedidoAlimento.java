public class PedidoAlimento extends Pedido {

    public PedidoAlimento(int id, String nomeCliente, double valor) throws ValorInvalidoException {
        super(id, nomeCliente, valor, Categoria.ALIMENTO);
    }

    public double calcularValorFinal() {
        return valor; // sem desconto
    }

    // PedidoAlimento NÃO implementa Entregavel; frete fixo interno para exibição
    public double calcularFrete() {
        return 5.0;
    }
}
