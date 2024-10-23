package balancaTryCatch.Exception;

import java.io.IOException;

public class ExceptionValorProdutoInvalido extends IllegalArgumentException {
    @Override
    public String getMessage() {
        return "O valor do produto é inválido! Deve ser maior que 0.";
    }
}
