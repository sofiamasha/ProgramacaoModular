import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PedidoEletronicoTest {

    PedidoEletronico pedidoBarato;
    PedidoEletronico pedidoCaro;

    @BeforeEach
    public void setUp() throws ValorInvalidoException {
        pedidoBarato = new PedidoEletronico(1, "Ana", 80.0);
        pedidoCaro   = new PedidoEletronico(2, "Bruno", 200.0);
    }

    @AfterEach
    public void tearDown() {
        System.out.println("Teste de PedidoEletronico finalizado.");
    }

    @Test
    public void testValorFinalSemDesconto() {
        assertEquals(80.0, pedidoBarato.calcularValorFinal(), 0.001);
    }

    @Test
    public void testValorFinalComDesconto() {
        // valor 200 > 100, desconto de 10%
        assertEquals(180.0, pedidoCaro.calcularValorFinal(), 0.001);
    }

    @Test
    public void testCalcularFrete() {
        // frete = 20 + 10% de 80 = 28
        assertEquals(28.0, pedidoBarato.calcularFrete(), 0.001);
    }

    @Test
    public void testValorInvalidoException() {
        assertThrows(ValorInvalidoException.class, () -> {
            new PedidoEletronico(3, "Carlos", -10.0);
        });
    }

    @Test
    public void testValorZeroLancaException() {
        assertThrows(ValorInvalidoException.class, () -> {
            new PedidoEletronico(4, "Diego", 0.0);
        });
    }

    @Test
    public void testProcessarPedidoMudaStatus() throws PedidoInvalidoException {
        assertEquals(StatusPedido.PENDENTE, pedidoBarato.getStatus());
        pedidoBarato.processarPedido();
        assertEquals(StatusPedido.PROCESSANDO, pedidoBarato.getStatus());
    }

    @Test
    public void testProcessarPedidoCanceladoLancaException() throws PedidoInvalidoException {
        pedidoBarato.alterarStatus(StatusPedido.CANCELADO);
        assertThrows(PedidoInvalidoException.class, () -> {
            pedidoBarato.processarPedido();
        });
    }

    @Test
    public void testAlterarStatusEntrequeNaoPode() throws PedidoInvalidoException {
        pedidoBarato.alterarStatus(StatusPedido.ENTREGUE);
        assertThrows(PedidoInvalidoException.class, () -> {
            pedidoBarato.alterarStatus(StatusPedido.CANCELADO);
        });
    }

    @Test
    public void testImplementaEntregavel() {
        assertTrue(pedidoBarato instanceof Entregavel);
    }
}
