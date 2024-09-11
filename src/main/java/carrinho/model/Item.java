package carrinho.model;

public class Item {
    private int codigo;
    private String descricao;
    private double acrescimo;
    private double desconto;
    private double preco;

    public Item(int codigo, String descricao, double preco) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.preco = preco;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getAcrescimo() {
        return acrescimo;
    }

    public void setAcrescimo(double acrescimo) {
        this.acrescimo = acrescimo;
    }

    public double getDesconto() {
        return desconto;
    }

    public void setDesconto(double desconto) {
        this.desconto = desconto;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String toString(){
        return "Codigo: " + codigo  + "\nDescrição: " + descricao + "\nPreço: " + preco +
                "\nDesconto: " + desconto + "\nAcrescimo: " + acrescimo +  "\n" +
                "___________________________________";
    }
}
