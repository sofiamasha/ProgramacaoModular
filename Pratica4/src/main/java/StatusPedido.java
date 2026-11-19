public enum StatusPedido {
    PENDENTE, PROCESSANDO, ENVIADO, ENTREGUE, CANCELADO;

    public boolean podeAlterar() {
        return this != ENTREGUE;
    }
}
