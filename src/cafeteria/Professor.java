package cafeteria;

import cafeteria.interfaces.ICliente;

public class Professor implements ICliente {
    private String nome;
    private static final double DESCONTO = 0.2f;

    public Professor(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public double aplicarDesconto(double valorOriginal) {
        return valorOriginal * (1 - DESCONTO);
    }
}