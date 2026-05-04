package main;

public class Pedido {
    private PedidoEstado estado;

    public Pedido() {
        this.estado = PedidoEstadoRecebido.getInstance();
    }

    public void setEstado(PedidoEstado estado) {
        this.estado = estado;
    }

    public boolean receber() {
        return estado.receber(this);
    }

    public boolean preparar() {
        return estado.preparar(this);
    }

    public boolean sairParaEntrega() {
        return estado.sairParaEntrega(this);
    }

    public boolean entregar() {
        return estado.entregar(this);
    }

    public boolean cancelar() {
        return estado.cancelar(this);
    }

    public String getNomeEstado() {
        return estado.getEstado();
    }

    public PedidoEstado getEstado() {
        return estado;
    }
}
