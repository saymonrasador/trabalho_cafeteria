package cafeteria;

import cafeteria.interfaces.IArquivo;
import cafeteria.interfaces.IPedido;
import java.io.FileWriter;
import java.io.IOException;

public class Arquivo implements IArquivo {
    private final String nomeArquivo;

    public Arquivo(String nomeArquivo) {
        this.nomeArquivo = nomeArquivo;
    }

    @Override
    public void salvarPedido(IPedido pedido) throws IOException {
        try (FileWriter writer = new FileWriter(nomeArquivo, true)) {
            String linha = String.format("Cliente: %s, Bebida: %s, Quantidade: %d, Total: %.2f\n",
                    pedido.getCliente().getNome(),
                    pedido.getBebida().getClass().getSimpleName(),
                    pedido.getQuantidade(),
                    pedido.getTotal());
            writer.write(linha);
        }
    }
}
