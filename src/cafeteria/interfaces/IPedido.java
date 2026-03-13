package cafeteria.interfaces;

public interface IPedido {
    public IBebida getBebida();
    public int getQuantidade();
    public ICliente getCliente();
    public double getTotal();
}
