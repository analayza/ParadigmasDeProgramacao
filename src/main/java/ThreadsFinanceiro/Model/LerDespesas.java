package ThreadsFinanceiro.Model;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class LerDespesas{

    String caminhoArquivo = "src\\main\\java\\ThreadsFinanceiro\\dataBase\\despesas.csv";
    String linha = "";
    HashMap<String, Double> despesas = new HashMap<>();
    boolean primeiraLinha = true;
    double despesasTotais = 0;
    public double getDespesasTotais(){
        return this.despesasTotais;
    }

    public String despesas() {
        try (BufferedReader br = new BufferedReader(new FileReader(caminhoArquivo))) {
            while ((linha = br.readLine()) != null) {
                if (primeiraLinha) {
                    primeiraLinha = false; // Ignora a primeira linha
                    continue;
                }
                String data = String.valueOf(linha.split(",")[0].split(" ")[0]);
                double valorDespesas = Double.parseDouble(linha.split(",")[1].replace("\"", "").trim());
                despesasTotais += valorDespesas;

                if(despesas.containsKey(data)){
                    double valorAntigo = despesas.get(data); //Pega o valor da Key data
                    double valorAtualizado = valorAntigo + valorDespesas;
                    despesas.put(data, valorAtualizado);
                }else{
                    despesas.put(data, valorDespesas);
                }
            }
        } catch (IOException e){
            e.printStackTrace();
        }
        return "Despesas: " + despesas + " \nTotal das Despesas: " + despesasTotais;
    }
}
