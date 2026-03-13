package cafeteria;

import java.io.FileWriter;
import java.io.IOException;

// Deveria ter uma classe Pedido, Bebida e Cliente, usando interfaces para definir os comportamentos (Interface Segregation Principle (ISP))

public class Cafeteria implements ICafeteria{
	public void processarPedido(IBebida bebida, int quantidade, ICliente cliente) {
		double precoBase = 0;

		// Deveria existir uma classe Bebida e cada tipo de bebida deveria ser uma
		// subclasse, usando polimorfismo para devolver o preço (Single Responsibility
		// Principle (SRP) e levar em consideração o liskov Substitution Principle
		// (LSP))
		if (tipoBebida.equalsIgnoreCase("Cafe")) {
			precoBase = 10.0;
		} else if (tipoBebida.equalsIgnoreCase("Capuccino")) {
			precoBase = 15.5;
		} else if (tipoBebida.equalsIgnoreCase("Cha")) {
			precoBase = 8.0;
		}
		// O cálculo do total do pedido deveria ser responsabilidade da classe Pedido, e
		// a classe Cafeteria apenas retornaria seus valores (Single Responsibility
		// Principle (SRP))
		double total = precoBase * quantidade;
		// Professor deveria ser uma subclasse de Cliente, usando polimorfismo para
		// aplicar o desconto (Liskov Substitution Principle (LSP))
		if (tipoCliente.equalsIgnoreCase("Professor")) {
			total = total * 0.8; // 20% de desconto
		}

		// Não deveria ser de responsabilidade da classe Cafeteria interagir diretamente
		// com o usuário, isso deveria ser responsabilidade de uma classe separada, e a
		// classe cafeteria apenas retornaria seus valores (Single Responsibility
		// Principle (SRP))
		System.out.println("Total do pedido: R$ " + total);

		// Não é responsabilidade da classe Cafeteria salvar o pedido em um arquivo,
		// isso deveria ser responsabilidade de uma classe separada (Single
		// Responsibility Principle (SRP))

		try {
			// Criar um método separado para salvar o pedido, seguindo o Single
			// Responsibility Principle (SRP)
			FileWriter writer = new FileWriter("log_pedidos.txt", true);
			// Não pode instanciar o FileWriter diretamente aqui, deveria depender de uma
			// interface para abstrair a escrita em arquivos (Dependency Inversion Principle
			// (DIP))
			writer.write("Pedido: " + tipoBebida + " | Total: " + total + "\n");
			writer.close();
			System.out.println("Pedido salvo no arquivo com sucesso.");
		} catch (IOException e) {
			System.out.println("Erro crítico no sistema de arquivos!");
		}
	}

	public void salvarPedido(IPedido pedido) {
		try {
			FileWriter writer = new FileWriter("log_pedidos.txt", true);
			writer.write("Pedido: " + pedido.getBebida().getNome() + " | Total: " + pedido.getTotal() + "\n");
			writer.close();
			System.out.println("Pedido salvo no arquivo com sucesso.");
		} catch (IOException e) {
			System.out.println("Erro crítico no sistema de arquivos!");
		}
	}

	public static void main(String[] args) {
		Cafeteria sistema = new Cafeteria();
		// Simulação de uso
		sistema.processarPedido(new Cha(), 2, new Cliente("Marcos"));
		sistema.processarPedido(new Capuccino(), 1, new Professor("Dr. Silva"));
	}
}
