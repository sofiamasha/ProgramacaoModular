public class PedidoEletronico extends Pedido implements Entregavel {

    public PedidoEletronico(int id, String nomeCliente, double valor) throws ValorInvalidoException {
        super(id, nomeCliente, valor, Categoria.ELETRONICO);
    }

    public double calcularValorFinal() {
        if (valor > 100) {
            return valor * 0.90; // 10% de desconto
        }
        return valor;
    }

    public double calcularFrete() {
        return 20 + valor * 0.10;
    }
}
