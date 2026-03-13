public interface ICafeteria {
    public void processarPedido(IBebida bebida, int quantidade, ICliente cliente);
    public void salvarPedido(IPedido pedido);
}
