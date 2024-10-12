package ThreadsFinanceiro.Model;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
public class LerReceitas{
    String caminhoArquivo = "src\\main\\java\\ThreadsFinanceiro\\dataBase\\receitas.csv";
    String linha = "";
    HashMap<String, Double> receita = new HashMap<>();
    boolean primeiraLinha = true;
    double receitasTotais = 0;
    public double getReceitasTotais(){
        return this.receitasTotais;
    }

    public String receitas() {
        try (BufferedReader br = new BufferedReader(new FileReader(caminhoArquivo))) {
            while ((linha = br.readLine()) != null) {
                if (primeiraLinha) {
                    primeiraLinha = false; // Ignora a primeira linha
                    continue;
                }
                String data = String.valueOf(linha.split(",")[0].split(" ")[0]);
                double valorReceitas = Double.parseDouble(linha.split(",")[1].replace("\"", "").trim());
                receitasTotais += valorReceitas;

                if(receita.containsKey(data)){
                    double valorAntigo = receita.get(data); //Pega o valor da Key data
                    double valorAtualizado = valorAntigo + valorReceitas;
                    receita.put(data, valorAtualizado);
                }else{
                    receita.put(data, valorReceitas);
                }
            }

        } catch (IOException e){
            e.printStackTrace();
        }
        return "Receitas: " + receita + " \nTotal das Receitas: " + receitasTotais;
    }
}
