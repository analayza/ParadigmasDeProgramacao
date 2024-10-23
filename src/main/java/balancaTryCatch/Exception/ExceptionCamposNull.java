package balancaTryCatch.Exception;

public class ExceptionCamposNull extends NullPointerException{  //Execeção Nativa (4)
    @Override
    public String getMessage() {
        return "Produto ou um dos campos estão nulos!";
    }
}
