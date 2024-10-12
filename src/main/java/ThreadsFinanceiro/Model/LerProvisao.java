package ThreadsFinanceiro.Model;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
public class LerProvisao{
    String caminhoArquivo = "src\\main\\java\\ThreadsFinanceiro\\dataBase\\provisao.csv";
    String linha = "";
    HashMap<String, Double> provisao = new HashMap<>();
    boolean primeiraLinha = true;
    double provisoesTotais = 0;
    public String provisao() {
        try (BufferedReader br = new BufferedReader(new FileReader(caminhoArquivo))) {
            while ((linha = br.readLine()) != null) {
                if (primeiraLinha) {
                    primeiraLinha = false; // Ignora a primeira linha
                    continue;
                }
                String data = String.valueOf(linha.split(",")[0].split(" ")[0]);
                double valorProvisao = Double.parseDouble(linha.split(",")[1].replace("\"", "").trim());
                provisoesTotais += valorProvisao;

                if(provisao.containsKey(data)){
                    double valorAntigo = provisao.get(data);
                    double valorAtualizado = valorAntigo + valorProvisao;
                    provisao.put(data, valorAtualizado);
                }else{
                    provisao.put(data, valorProvisao);
                }
            }

        } catch (IOException e){
            e.printStackTrace();
        }
        return "Provisões: " + provisao + " \nTotal das Provisões: " + provisoesTotais;
    }
}
