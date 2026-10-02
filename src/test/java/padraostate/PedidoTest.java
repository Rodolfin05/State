package padraostate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PedidoTest {

    Pedido pedido;

    @BeforeEach
    public void setUp() {
        pedido = new Pedido();
    }

    @Test
    public void deveIniciarAguardandoPagamento() {
        assertEquals(PedidoEstadoAguardandoPagamento.getInstance(), pedido.getEstado());
    }

    // Pedido AguardandoPagamento

    @Test
    public void devePagarPedidoAguardandoPagamento() {
        pedido.setEstado(PedidoEstadoAguardandoPagamento.getInstance());
        assertTrue(pedido.pagar());
        assertEquals(PedidoEstadoPago.getInstance(), pedido.getEstado());
    }

    @Test
    public void naoDeveEnviarPedidoAguardandoPagamento() {
        pedido.setEstado(PedidoEstadoAguardandoPagamento.getInstance());
        assertFalse(pedido.enviar());
        assertEquals(PedidoEstadoAguardandoPagamento.getInstance(), pedido.getEstado());
    }

    @Test
    public void naoDeveEntregarPedidoAguardandoPagamento() {
        pedido.setEstado(PedidoEstadoAguardandoPagamento.getInstance());
        assertFalse(pedido.entregar());
        assertEquals(PedidoEstadoAguardandoPagamento.getInstance(), pedido.getEstado());
    }

    @Test
    public void deveCancelarPedidoAguardandoPagamento() {
        pedido.setEstado(PedidoEstadoAguardandoPagamento.getInstance());
        assertTrue(pedido.cancelar());
        assertEquals(PedidoEstadoCancelado.getInstance(), pedido.getEstado());
    }

    // Pedido Pago

    @Test
    public void naoDevePagarPedidoPago() {
        pedido.setEstado(PedidoEstadoPago.getInstance());
        assertFalse(pedido.pagar());
        assertEquals(PedidoEstadoPago.getInstance(), pedido.getEstado());
    }

    @Test
    public void deveEnviarPedidoPago() {
        pedido.setEstado(PedidoEstadoPago.getInstance());
        assertTrue(pedido.enviar());
        assertEquals(PedidoEstadoEnviado.getInstance(), pedido.getEstado());
    }

    @Test
    public void naoDeveEntregarPedidoPago() {
        pedido.setEstado(PedidoEstadoPago.getInstance());
        assertFalse(pedido.entregar());
        assertEquals(PedidoEstadoPago.getInstance(), pedido.getEstado());
    }

    @Test
    public void deveCancelarPedidoPago() {
        pedido.setEstado(PedidoEstadoPago.getInstance());
        assertTrue(pedido.cancelar());
        assertEquals(PedidoEstadoCancelado.getInstance(), pedido.getEstado());
    }

    // Pedido Enviado

    @Test
    public void naoDevePagarPedidoEnviado() {
        pedido.setEstado(PedidoEstadoEnviado.getInstance());
        assertFalse(pedido.pagar());
        assertEquals(PedidoEstadoEnviado.getInstance(), pedido.getEstado());
    }

    @Test
    public void naoDeveEnviarPedidoEnviado() {
        pedido.setEstado(PedidoEstadoEnviado.getInstance());
        assertFalse(pedido.enviar());
        assertEquals(PedidoEstadoEnviado.getInstance(), pedido.getEstado());
    }

    @Test
    public void deveEntregarPedidoEnviado() {
        pedido.setEstado(PedidoEstadoEnviado.getInstance());
        assertTrue(pedido.entregar());
        assertEquals(PedidoEstadoEntregue.getInstance(), pedido.getEstado());
    }

    @Test
    public void naoDeveCancelarPedidoEnviado() {
        pedido.setEstado(PedidoEstadoEnviado.getInstance());
        assertFalse(pedido.cancelar());
        assertEquals(PedidoEstadoEnviado.getInstance(), pedido.getEstado());
    }

    // Pedido Entregue

    @Test
    public void naoDevePagarPedidoEntregue() {
        pedido.setEstado(PedidoEstadoEntregue.getInstance());
        assertFalse(pedido.pagar());
        assertEquals(PedidoEstadoEntregue.getInstance(), pedido.getEstado());
    }

    @Test
    public void naoDeveEnviarPedidoEntregue() {
        pedido.setEstado(PedidoEstadoEntregue.getInstance());
        assertFalse(pedido.enviar());
        assertEquals(PedidoEstadoEntregue.getInstance(), pedido.getEstado());
    }

    @Test
    public void naoDeveEntregarPedidoEntregue() {
        pedido.setEstado(PedidoEstadoEntregue.getInstance());
        assertFalse(pedido.entregar());
        assertEquals(PedidoEstadoEntregue.getInstance(), pedido.getEstado());
    }

    @Test
    public void naoDeveCancelarPedidoEntregue() {
        pedido.setEstado(PedidoEstadoEntregue.getInstance());
        assertFalse(pedido.cancelar());
        assertEquals(PedidoEstadoEntregue.getInstance(), pedido.getEstado());
    }

    // Pedido Cancelado

    @Test
    public void naoDevePagarPedidoCancelado() {
        pedido.setEstado(PedidoEstadoCancelado.getInstance());
        assertFalse(pedido.pagar());
        assertEquals(PedidoEstadoCancelado.getInstance(), pedido.getEstado());
    }

    @Test
    public void naoDeveEnviarPedidoCancelado() {
        pedido.setEstado(PedidoEstadoCancelado.getInstance());
        assertFalse(pedido.enviar());
        assertEquals(PedidoEstadoCancelado.getInstance(), pedido.getEstado());
    }

    @Test
    public void naoDeveEntregarPedidoCancelado() {
        pedido.setEstado(PedidoEstadoCancelado.getInstance());
        assertFalse(pedido.entregar());
        assertEquals(PedidoEstadoCancelado.getInstance(), pedido.getEstado());
    }

    @Test
    public void naoDeveCancelarPedidoCancelado() {
        pedido.setEstado(PedidoEstadoCancelado.getInstance());
        assertFalse(pedido.cancelar());
        assertEquals(PedidoEstadoCancelado.getInstance(), pedido.getEstado());
    }
}
