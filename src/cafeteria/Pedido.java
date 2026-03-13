public class Pedido implements IPedido {
    private IBebida bebida;
    private int quantidade;
    private ICliente cliente;
    private double total;

    public Pedido(IBebida bebida, int quantidade, ICliente cliente) {
        this.bebida = bebida;
        this.quantidade = quantidade;
        this.cliente = cliente;
        this.total = calcularTotal();
    }

    private double calcularTotal() {
        double precoBase = bebida.getPreco() * quantidade;
        if (cliente.getDesconto() > 0) {
            precoBase *= (1 - cliente.getDesconto());
        }
        return precoBase;
    }

    public IBebida getBebida() {
        return bebida;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public double getTotal() {
        return total;
    }

    public ICliente getCliente() {
        return cliente;
    }
}
