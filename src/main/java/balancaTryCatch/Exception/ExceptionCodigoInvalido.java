package balancaTryCatch.Exception;

public class ExceptionCodigoInvalido extends  IllegalArgumentException{ //Utiliza IllegalArgumentException (Nativa 5)
    @Override
    public String getMessage() {
        return "Produto ou um dos campos estão nulos!";
    }
}
