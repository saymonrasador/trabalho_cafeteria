package cafeteria.interfaces;

public interface IUI {
    void mostrarMensagem(String mensagem);
    String obterEntrada(String prompt);
    void mensagemTotalPedido(IPedido pedido);
    void mensagemErroArquivo();
}