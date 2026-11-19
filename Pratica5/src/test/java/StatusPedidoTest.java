import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StatusPedidoTest {

    @BeforeEach
    public void setUp() {
        // sem estado para preparar; enums são estáticos
    }

    @AfterEach
    public void tearDown() {
        System.out.println("Teste de StatusPedido finalizado.");
    }

    @Test
    public void testEntrequeNaoPodeAlterar() {
        assertFalse(StatusPedido.ENTREGUE.podeAlterar());
    }

    @Test
    public void testDemaisPodemAlterar() {
        assertTrue(StatusPedido.PENDENTE.podeAlterar());
        assertTrue(StatusPedido.PROCESSANDO.podeAlterar());
        assertTrue(StatusPedido.ENVIADO.podeAlterar());
        assertTrue(StatusPedido.CANCELADO.podeAlterar());
    }

    @Test
    public void testAlterarStatusEntregueDispararaException() throws ValorInvalidoException, PedidoInvalidoException {
        PedidoEletronico p = new PedidoEletronico(99, "Teste", 100.0);
        p.alterarStatus(StatusPedido.ENTREGUE);
        assertThrows(PedidoInvalidoException.class, () -> {
            p.alterarStatus(StatusPedido.PENDENTE);
        });
    }

    @Test
    public void testStatusInicial() throws ValorInvalidoException {
        PedidoRoupa r = new PedidoRoupa(10, "Maria", 50.0);
        assertEquals(StatusPedido.PENDENTE, r.getStatus());
    }
}
