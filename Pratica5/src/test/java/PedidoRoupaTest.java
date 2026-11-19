import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PedidoRoupaTest {

    PedidoRoupa pedidoBarato;
    PedidoRoupa pedidoCaro;

    @BeforeEach
    public void setUp() throws ValorInvalidoException {
        pedidoBarato = new PedidoRoupa(1, "Ana", 150.0);
        pedidoCaro   = new PedidoRoupa(2, "Bruno", 300.0);
    }

    @AfterEach
    public void tearDown() {
        System.out.println("Teste de PedidoRoupa finalizado.");
    }

    @Test
    public void testValorFinalSemDesconto() {
        // 150 <= 200, sem desconto
        assertEquals(150.0, pedidoBarato.calcularValorFinal(), 0.001);
    }

    @Test
    public void testValorFinalComDesconto() {
        // 300 > 200, desconto de 20%
        assertEquals(240.0, pedidoCaro.calcularValorFinal(), 0.001);
    }

    @Test
    public void testCalcularFrete() {
        // frete = 10 + 5% de 150 = 17.50
        assertEquals(17.5, pedidoBarato.calcularFrete(), 0.001);
    }

    @Test
    public void testValorInvalidoException() {
        assertThrows(ValorInvalidoException.class, () -> {
            new PedidoRoupa(3, "Carlos", 0.0);
        });
    }

    @Test
    public void testProcessarPedidoMudaStatus() throws PedidoInvalidoException {
        pedidoBarato.processarPedido();
        assertEquals(StatusPedido.PROCESSANDO, pedidoBarato.getStatus());
    }

    @Test
    public void testProcessarEntregueJaLancaException() throws PedidoInvalidoException {
        pedidoBarato.alterarStatus(StatusPedido.ENTREGUE);
        assertThrows(PedidoInvalidoException.class, () -> {
            pedidoBarato.processarPedido();
        });
    }

    @Test
    public void testAlterarStatusEntrequeNaoPode() throws PedidoInvalidoException {
        pedidoBarato.alterarStatus(StatusPedido.ENTREGUE);
        assertThrows(PedidoInvalidoException.class, () -> {
            pedidoBarato.alterarStatus(StatusPedido.ENVIADO);
        });
    }

    @Test
    public void testImplementaEntregavel() {
        assertTrue(pedidoBarato instanceof Entregavel);
    }
}
