package cafeteria;

import cafeteria.interfaces.IArquivo;
import cafeteria.interfaces.IBebida;
import cafeteria.interfaces.ICafeteria;
import cafeteria.interfaces.ICliente;
import cafeteria.interfaces.IPedido;
import cafeteria.interfaces.IUI;
import java.io.FileWriter;
import java.io.IOException;

public class Cafeteria implements ICafeteria{
	private IUI ui;	
	private IArquivo arquivo;	

	public Cafeteria(IUI ui, IArquivo arquivo) {
		this.ui = ui;
		this.arquivo = arquivo;
	}

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
		IUI ui = new UI();
		IArquivo arquivo = new Arquivo("pedidos.txt");
		Cafeteria sistema = new Cafeteria(ui, arquivo);
		// Simulação de uso
		sistema.processarPedido(new Cha(), 2, new Cliente("Marcos"));
		sistema.processarPedido(new Capuccino(), 1, new Professor("Dr. Silva"));
	}
}
