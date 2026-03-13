public class Cliente implements ICliente {
    private String nome;
    private float desconto;

    public Cliente(String nome) {
        this.nome = nome;
        this.desconto = 0.0f;
    }

    public String getNome() {
        return nome;
    }

    public float getDesconto() {
        return desconto;
    }
}