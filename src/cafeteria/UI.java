public class UI implements IUI {
    public void mostrarMensagem(String mensagem) {
        System.out.println(mensagem);
    }

    public String obterEntrada(String prompt) {
        System.out.print(prompt);
        return new Scanner(System.in).nextLine();
    }

    public void mensagemTotalPedido(IPedido pedido) {
        System.out.println("Total do pedido: R$ " + pedido.getTotal());
    }

    public void mensagemErroArquivo() {
        System.out.println("Erro crítico no sistema de arquivos!");
    }
}
