public class Pedido implements IPedido {
    private IBebida bebida;
    private int quantidade;
    private ICliente cliente;

    public Pedido(IBebida bebida, int quantidade, ICliente cliente) {
        this.bebida = bebida;
        this.quantidade = quantidade;
        this.cliente = cliente;
    }

    public IBebida getBebida() {
        return bebida;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public ICliente getCliente() {
        return cliente;
    }

    public float getTotal() {
        float total = bebida.getPreco() * quantidade;
        if (cliente.getDesconto() > 0) {
            total *= (1 - cliente.getDesconto());
        }
        return total;
    }
}
