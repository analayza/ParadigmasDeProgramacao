package br.com.subsistema.imposto;

import br.com.subsistema.model.Item;

public interface Imposto {
    public double calcular(Item item);
}
