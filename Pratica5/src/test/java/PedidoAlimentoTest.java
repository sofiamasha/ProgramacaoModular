import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PedidoAlimentoTest {

    PedidoAlimento pedido;

    @BeforeEach
    public void setUp() throws ValorInvalidoException {
        pedido = new PedidoAlimento(1, "Ana", 50.0);
    }

    @AfterEach
    public void tearDown() {
        System.out.println("Teste de PedidoAlimento finalizado.");
    }

    @Test
    public void testValorFinalSemDesconto() {
        assertEquals(50.0, pedido.calcularValorFinal(), 0.001);
    }

    @Test
    public void testFreteFixo() {
        assertEquals(5.0, pedido.calcularFrete(), 0.001);
    }

    @Test
    public void testValorInvalidoException() {
        assertThrows(ValorInvalidoException.class, () -> {
            new PedidoAlimento(2, "Bruno", -1.0);
        });
    }

    @Test
    public void testNaoImplementaEntregavel() {
        assertFalse(pedido instanceof Entregavel);
    }

    @Test
    public void testProcessarPedidoMudaStatus() throws PedidoInvalidoException {
        pedido.processarPedido();
        assertEquals(StatusPedido.PROCESSANDO, pedido.getStatus());
    }

    @Test
    public void testProcessarCanceladoLancaException() throws PedidoInvalidoException {
        pedido.alterarStatus(StatusPedido.CANCELADO);
        assertThrows(PedidoInvalidoException.class, () -> {
            pedido.processarPedido();
        });
    }
}
