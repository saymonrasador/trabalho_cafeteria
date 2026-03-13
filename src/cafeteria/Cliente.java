package cafeteria;

import cafeteria.interfaces.ICliente;

public class Cliente implements ICliente {
    private String nome;

    public Cliente(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public double aplicarDesconto(double valorOriginal) {
        return valorOriginal;
    }
}