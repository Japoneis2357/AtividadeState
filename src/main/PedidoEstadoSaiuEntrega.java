package main;

public class PedidoEstadoSaiuEntrega extends PedidoEstado {

    private PedidoEstadoSaiuEntrega() {}
    private static PedidoEstadoSaiuEntrega instance = new PedidoEstadoSaiuEntrega();

    public static PedidoEstadoSaiuEntrega getInstance() {
        return instance;
    }

    public String getEstado() {
        return "Saiu para entrega";
    }

    public boolean preparar(Pedido pedido) {
        pedido.setEstado(PedidoEstadoEmPreparo.getInstance());
        return true;
    }

    public boolean entregar(Pedido pedido) {
        pedido.setEstado(PedidoEstadoEntregue.getInstance());
        return true;
    }

    public boolean cancelar(Pedido pedido) {
        pedido.setEstado(PedidoEstadoCancelado.getInstance());
        return true;
    }
}
