package cafeteria.interfaces;

import java.io.IOException;

public interface IArquivo {
    void salvarPedido(IPedido pedido) throws IOException;
}