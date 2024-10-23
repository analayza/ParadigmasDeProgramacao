package balancaTryCatch.Exception;

public class ExceptionDescricaoInvalida extends IllegalArgumentException{
    @Override
    public String getMessage() {
        return "A descrição do produto é inválida! Deve ter pelo menos 3 caracteres.";
    }
}
