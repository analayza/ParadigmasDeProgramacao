package balancaTryCatch.factory;

import balancaTryCatch.Exception.ExceptionTipoNull;
import balancaTryCatch.enums.TipoBalanca;
import balancaTryCatch.interfaces.IBalanca;
import balancaTryCatch.models.Produto;
import balancaTryCatch.service.FilizolaSmart;
import balancaTryCatch.service.ToledoMGV6;
import balancaTryCatch.service.UranoIntegra;

public class BalancaFactory {
    public static IBalanca<Produto> getBalanca(TipoBalanca tipo)throws ExceptionTipoNull {

        if(tipo == null){
            throw  new ExceptionTipoNull("Erro: O tipo não pode ser null");    //Execeção personalizada 6
        }
            switch (tipo) {
                case FINIZOLA_SMART:
                    return new FilizolaSmart();
                case TOLEDO_MGV6:
                    return new ToledoMGV6();
                case URANO_INTEGRA:
                    return new UranoIntegra();
                default:
                    throw new ExceptionTipoNull("Tipo desconhecido: null:  " + tipo);
            }
    }
}
