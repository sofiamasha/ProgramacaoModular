public abstract class Pedido implements Processavel {

    protected int id;
    protected String nomeCliente;
    protected double valor;
    protected StatusPedido status;
    protected Categoria categoria;

    public Pedido(int id, String nomeCliente, double valor, Categoria categoria) throws ValorInvalidoException {
        if (valor <= 0) {
            throw new ValorInvalidoException("Valor deve ser maior que zero.");
        }
        this.id = id;
        this.nomeCliente = nomeCliente;
        this.valor = valor;
        this.categoria = categoria;
        this.status = StatusPedido.PENDENTE;
    }

    public void processarPedido() throws PedidoInvalidoException {
        if (status == StatusPedido.CANCELADO) {
            throw new PedidoInvalidoException("Pedido cancelado não pode ser processado.");
        }
        if (status == StatusPedido.ENTREGUE) {
            throw new PedidoInvalidoException("Pedido já entregue não pode mudar de status.");
        }
        status = StatusPedido.PROCESSANDO;
    }

    public void alterarStatus(StatusPedido novoStatus) throws PedidoInvalidoException {
        if (!status.podeAlterar()) {
            throw new PedidoInvalidoException("Pedido com status ENTREGUE não pode ser alterado.");
        }
        this.status = novoStatus;
    }

    public int getId() { return id; }
    public String getNomeCliente() { return nomeCliente; }
    public double getValor() { return valor; }
    public StatusPedido getStatus() { return status; }
    public Categoria getCategoria() { return categoria; }

    public String toString() {
        return "Pedido #" + id + " | " + nomeCliente + " | R$" + String.format("%.2f", valor)
                + " | " + categoria + " | " + status;
    }
}
