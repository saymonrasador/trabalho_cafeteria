public class Professor implements ICliente {
    private String nome;
    private float desconto;

    public Professor(String nome) {
        this.nome = nome;
        this.desconto = 0.2f;
    }

    public String getNome() {
        return nome;
    }

    public float getDesconto() {
        return desconto;
    }
}