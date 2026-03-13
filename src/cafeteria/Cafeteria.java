package cafeteria;

import java.io.FileWriter;
import java.io.IOException;

public class Cafeteria implements ICafeteria{
	IUI ui = new UI();	
	IArquivo arquivo = new Arquivo();	

	public void processarPedido(IBebida bebida, int quantidade, ICliente cliente) {
		Pedido pedido = new Pedido(bebida, quantidade, cliente);
		double total = pedido.getTotal();

		ui.mensagemTotalPedido(pedido);
		this.salvarPedido(pedido);
	}

	public void salvarPedido(IPedido pedido) {
		try {
			arquivo.salvarPedido(pedido);
		} catch (IOException e) {
			ui.mensagemErroArquivo();
		}
	}

	public static void main(String[] args) {
		Cafeteria sistema = new Cafeteria();
		// Simulação de uso
		sistema.processarPedido(new Cha(), 2, new Cliente("Marcos"));
		sistema.processarPedido(new Capuccino(), 1, new Professor("Dr. Silva"));
	}
}
