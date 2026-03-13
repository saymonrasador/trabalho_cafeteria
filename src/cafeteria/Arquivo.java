public class Arquivo implements IArquivo {
    private final String nomeArquivo = "pedidos.txt";

    @Override
    public void salvarPedido(IPedido pedido) {
        try (FileWriter writer = new FileWriter(nomeArquivo, true)) {
            String linha = String.format("Cliente: %s, Bebida: %s, Quantidade: %d, Total: %.2f\n",
                    pedido.getCliente().getNome(),
                    pedido.getBebida().getClass().getSimpleName(),
                    pedido.getQuantidade(),
                    pedido.getTotal());
            writer.write(linha);
        } catch (IOException e) {
            System.out.println("Erro ao salvar pedido: " + e.getMessage());
        }
    }
}
