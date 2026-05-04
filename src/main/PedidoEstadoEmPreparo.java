package main;

public class PedidoEstadoEmPreparo extends PedidoEstado {

    private PedidoEstadoEmPreparo() {}
    private static PedidoEstadoEmPreparo instance = new PedidoEstadoEmPreparo();

    public static PedidoEstadoEmPreparo getInstance() {
        return instance;
    }

    public String getEstado() {
        return "Em preparo";
    }

    public boolean receber(Pedido pedido) {
        pedido.setEstado(PedidoEstadoRecebido.getInstance());
        return true;
    }

    public boolean sairParaEntrega(Pedido pedido) {
        pedido.setEstado(PedidoEstadoSaiuEntrega.getInstance());
        return true;
    }

    public boolean cancelar(Pedido pedido) {
        pedido.setEstado(PedidoEstadoCancelado.getInstance());
        return true;
    }
}
