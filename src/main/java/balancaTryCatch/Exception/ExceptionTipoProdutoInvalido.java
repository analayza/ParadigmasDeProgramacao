package balancaTryCatch.Exception;

public class ExceptionTipoProdutoInvalido extends IllegalArgumentException{
    @Override
    public String getMessage() {
        return "O tipo do produto é inválido! Deve ser 6 (unidade) ou 9 (peso).";
    }
}
