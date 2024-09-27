package br.com.subsistema.factory;

import br.com.subsistema.imposto.*;

public class ImpostoFactory {

    public Imposto getImposto(TipoImposto tipoImposto){
        switch (tipoImposto){
            case TIPOICMS:
                return new ICMS();
            case TIPOIPI:
                return new IPI();
            case TIPOPIS:
                return new PIS();
            case TIPOISS:
                return new ISS();
            default:
                throw new IllegalArgumentException("Tipo de imposto não reconhecido.");
        }
    }
}


