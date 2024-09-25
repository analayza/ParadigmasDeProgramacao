package geradorDeEtiquetas.domain;
import java.text.NumberFormat;
import java.util.Locale;

public class GeradorDeEtiquetas {
    public static String gerarEtiqueta(Produto produto){
        String descricaoDaEtiqueta = produto.getDescricao();
        String descricaoCorreta = "";
        if(produto.getDescricao().length() > 22){
            descricaoCorreta = descricaoDaEtiqueta.substring(0,22);
        }
        else if(produto.getDescricao().length() <= 22){
            descricaoCorreta = descricaoDaEtiqueta;
        }

        String formatacaoCaixa = String.format("%.2f", produto.getPrecoCaixa());
        String formatadoCaixa = "R$"+formatacaoCaixa.replace("."  , ",");

        String formatacaoLata = String.format("%.2f", produto.getPrecoLata());
        String formatadoLata = "R$"+formatacaoLata.replace("."  , ",");

        return "^XA\n" +
                "^CFO,60\n" +
                "^FO50,50^FD"+descricaoCorreta+ "^FS\n" +
                "^CFA,50\n" +
                "^FO50,200^FDLata    "+formatadoLata +"^FS\n" +
                "^FO50,280^FDCaixa   "+formatadoCaixa +"^FS\n" +
                "^BY5,2,270\n" +
                "^FO100,450^BC^FD" + produto.getCodigoBarras() + "^FS\n" +
                "^XZ";
    }
}
