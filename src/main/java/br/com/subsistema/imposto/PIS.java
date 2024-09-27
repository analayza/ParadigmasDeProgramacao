package br.com.subsistema.imposto;

import br.com.subsistema.model.Item;
import br.com.subsistema.model.Produto;

public class PIS implements Imposto{

    @Override
    public double calcular(Item item) {
        if(item instanceof Produto){
            return item.getValor() * 0.0065;
        }else{
            throw new IllegalArgumentException("PIS só pode ser aplicado a Produtos.");
        }
    }
}
