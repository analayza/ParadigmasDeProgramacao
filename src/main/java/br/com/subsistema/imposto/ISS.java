package br.com.subsistema.imposto;

import br.com.subsistema.model.Item;
import br.com.subsistema.model.Servico;

public class ISS implements Imposto{

    @Override
    public double calcular(Item item) {
        if(item instanceof Servico){
            return item.getValor() * 0.22;
        }else{
            throw new IllegalArgumentException("ISS só pode ser aplicado a Serviços.");
        }
    }
}
