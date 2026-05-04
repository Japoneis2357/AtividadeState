package test;

import main.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PedidoTest {
    Pedido pedido;

    @BeforeEach
    public void setUp() {
        pedido = new Pedido();
    }

    //Recebido
    @Test
    public void PedidoRecebidoNaoDeveReceber() {
        pedido.setEstado(PedidoEstadoRecebido.getInstance());
        assertFalse(pedido.receber());
    }
    @Test
    public void PedidoRecebidoDevePrepararar() {
        pedido.setEstado(PedidoEstadoRecebido.getInstance());
        assertTrue(pedido.preparar());
        assertEquals(PedidoEstadoEmPreparo.getInstance(), pedido.getEstado());
    }
    @Test
    public void PedidoRecebidoNaoDeveSairParaEntrega() {
        pedido.setEstado(PedidoEstadoRecebido.getInstance());
        assertFalse(pedido.sairParaEntrega());
    }
    @Test
    public void PedidoRecebidoNaoDeveEntregar() {
        pedido.setEstado(PedidoEstadoRecebido.getInstance());
        assertFalse(pedido.entregar());
    }
    @Test
    public void PedidoRecebidoDeveCancelar() {
        pedido.setEstado(PedidoEstadoRecebido.getInstance());
        assertTrue(pedido.cancelar());
        assertEquals(PedidoEstadoCancelado.getInstance(), pedido.getEstado());
    }

    //Em Preparo
    @Test
    public void PedidoEmPreparoDeveReceber() {
        pedido.setEstado(PedidoEstadoEmPreparo.getInstance());
        assertTrue(pedido.receber());
        assertEquals(PedidoEstadoRecebido.getInstance(), pedido.getEstado());
    }
    @Test
    public void PedidoEmPreparoNaoDevePrepararar() {
        pedido.setEstado(PedidoEstadoEmPreparo.getInstance());
        assertFalse(pedido.preparar());
    }
    @Test
    public void PedidoEmPreparoDeveSairParaEntrega() {
        pedido.setEstado(PedidoEstadoEmPreparo.getInstance());
        assertTrue(pedido.sairParaEntrega());
        assertEquals(PedidoEstadoSaiuEntrega.getInstance(), pedido.getEstado());
    }
    @Test
    public void PedidoEmPreparoNaoDeveEntregar() {
        pedido.setEstado(PedidoEstadoEmPreparo.getInstance());
        assertFalse(pedido.entregar());
    }
    @Test
    public void PedidoEmPreparoDeveCancelar() {
        pedido.setEstado(PedidoEstadoEmPreparo.getInstance());
        assertTrue(pedido.cancelar());
        assertEquals(PedidoEstadoCancelado.getInstance(), pedido.getEstado());
    }

    //Saiu para Entrega
    @Test
    public void PedidoSaiuEntregaNaoDeveReceber() {
        pedido.setEstado(PedidoEstadoSaiuEntrega.getInstance());
        assertFalse(pedido.receber());
    }
    @Test
    public void PedidoSaiuEntregaDevePrepararar() {
        pedido.setEstado(PedidoEstadoSaiuEntrega.getInstance());
        assertTrue(pedido.preparar());
        assertEquals(PedidoEstadoEmPreparo.getInstance(), pedido.getEstado());
    }
    @Test
    public void PedidoSaiuEntregaNaoDeveSairParaEntrega() {
        pedido.setEstado(PedidoEstadoSaiuEntrega.getInstance());
        assertFalse(pedido.sairParaEntrega());
    }
    @Test
    public void PedidoSaiuEntregaDeveEntregar() {
        pedido.setEstado(PedidoEstadoSaiuEntrega.getInstance());
        assertTrue(pedido.entregar());
        assertEquals(PedidoEstadoEntregue.getInstance(), pedido.getEstado());
    }
    @Test
    public void PedidoSaiuEntregaDeveCancelar() {
        pedido.setEstado(PedidoEstadoSaiuEntrega.getInstance());
        assertTrue(pedido.cancelar());
        assertEquals(PedidoEstadoCancelado.getInstance(), pedido.getEstado());
    }

    //Entregue
    @Test
    public void PedidoEntregueNaoDeveReceber() {
        pedido.setEstado(PedidoEstadoEntregue.getInstance());
        assertFalse(pedido.receber());
    }
    @Test
    public void PedidoEntregueNaoDevePrepararar() {
        pedido.setEstado(PedidoEstadoEntregue.getInstance());
        assertFalse(pedido.preparar());
    }
    @Test
    public void PedidoEntregueNaoDeveSairParaEntrega() {
        pedido.setEstado(PedidoEstadoEntregue.getInstance());
        assertFalse(pedido.sairParaEntrega());
    }
    @Test
    public void PedidoEntregueNaoDeveEntregar() {
        pedido.setEstado(PedidoEstadoEntregue.getInstance());
        assertFalse(pedido.entregar());
    }
    @Test
    public void PedidoEntregueNaoDeveCancelar() {
        pedido.setEstado(PedidoEstadoEntregue.getInstance());
        assertFalse(pedido.cancelar());
    }

    //Cancelado
    @Test
    public void PedidoCanceladoNaoDeveReceber() {
        pedido.setEstado(PedidoEstadoCancelado.getInstance());
        assertFalse(pedido.receber());
    }
    @Test
    public void PedidoCanceladoNaoDevePrepararar() {
        pedido.setEstado(PedidoEstadoCancelado.getInstance());
        assertFalse(pedido.preparar());
    }
    @Test
    public void PedidoCanceladoNaoDeveSairParaEntrega() {
        pedido.setEstado(PedidoEstadoCancelado.getInstance());
        assertFalse(pedido.sairParaEntrega());
    }
    @Test
    public void PedidoCanceladoNaoDeveEntregar() {
        pedido.setEstado(PedidoEstadoCancelado.getInstance());
        assertFalse(pedido.entregar());
    }
    @Test
    public void PedidoCanceladoNaoDeveCancelar() {
        pedido.setEstado(PedidoEstadoCancelado.getInstance());
        assertFalse(pedido.cancelar());
    }
}
