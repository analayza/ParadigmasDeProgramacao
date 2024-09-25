package geradorDeEtiquetas.main;

import geradorDeEtiquetas.domain.GeradorDeEtiquetas;
import geradorDeEtiquetas.domain.Produto;

public class Main {
    public static void main(String[] args) {
        GeradorDeEtiquetas geradorDeEtiquetas = new GeradorDeEtiquetas();
        Produto produto = new Produto("Tapioca Voita",
                7, 800,"24835232");

        String etiquetaZPL = GeradorDeEtiquetas.gerarEtiqueta(produto);
        System.out.println(etiquetaZPL);

    }
}
