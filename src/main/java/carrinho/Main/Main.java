package carrinho.Main;

import carrinho.model.Carrinho;
import carrinho.model.Item;


public class Main {
    public static void main(String[] args) {

        var carrinho = new Carrinho();
        carrinho.inserir(new Item(1, "Refrigerante de Laranja", 8 ));
        carrinho.inserir(new Item(2, "Suco de Laranja", 6 ));

        carrinho.acrescimoItem(1, 2);
        //carrinho.descontoItem(2, 1);

        carrinho.acrescimoTotal(10);


        carrinho.finalizarVenda();

    }
}
