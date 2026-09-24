package entities;

public class Peca {
    private String nome;
    private String modelo;
    private String marca;
    private int quantidade;

    public Peca(String nome, String modelo, String marca, int quantidade) {
        this.nome = nome;
        this.modelo = modelo;
        this.marca = marca;
        this.quantidade = quantidade;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQuantidade() {
        return quantidade;
    }
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void darEntrada(int quantidade) {
        this.quantidade += quantidade;
    }

    public boolean darBaixa(int qtdRetirada) {
        if (this.quantidade >= qtdRetirada) {
            this.quantidade -= qtdRetirada;
            return true;
        }
        return false;
    }

      public boolean mesmaPeca(String nome, String modelo, String marca){
        return this.nome.equals(nome) && this.modelo.equals(modelo) && this.marca.equals(marca);
      }

    @Override
    public String toString() {
        return  "Nome = " + nome + "\n"
                + "Modelo = " + modelo + "\n"
                + "Marca = " + marca + "\n"
                + "Quantidade em estoque = " + quantidade + "\n";
    }
}