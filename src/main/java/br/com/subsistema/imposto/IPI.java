package br.com.subsistema.imposto;

import br.com.subsistema.model.Item;
import br.com.subsistema.model.Produto;

public class IPI implements Imposto{

    @Override
    public double calcular(Item item) {
        if(item instanceof Produto && ((Produto) item).industrial == true){
            return item.getValor() * 0.0065;
        }else if(item instanceof Produto && ((Produto) item).industrial == false){
            return item.getValor();
        }
        else{
            throw new IllegalArgumentException("IPI só pode ser aplicado a Produtos.");
        }
    }
}
