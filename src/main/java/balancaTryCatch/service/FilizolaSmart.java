package balancaTryCatch.service;

import balancaTryCatch.Exception.*;
import balancaTryCatch.interfaces.IBalanca;
import balancaTryCatch.models.Produto;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class FilizolaSmart implements IBalanca<Produto>  {
    @Override
    public void exportar(List<Produto> produtos, String pastaArquivoTxt) {
        File directory = new File(pastaArquivoTxt);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(pastaArquivoTxt + "/CADTXT.TXT"))) {
            for (Produto produto : produtos) {
                String linha = formatarProduto(produto);
                writer.write(linha);
                writer.newLine();
            }
        } catch (IOException e) {  //Exceção nativa (1)
            System.err.println("Erro: " + e);
        }
    }

    private String formatarProduto(Produto produto) {

        if (produto == null || produto.getDescricao() == null || produto.getTipo() == null) {
            throw new ExceptionCamposNull(); //Exceção Personalizada (1)
        }
        if (produto.getCodigo() <= 0) {
            throw new ExceptionCodigoInvalido(); //Exceção Personalizada (2)
        }
        if (produto.getDescricao().length() < 3) {
            throw new ExceptionDescricaoInvalida(); //Exceção Personalizada (3)
        }
        if (!produto.getTipo().equals("6") && !produto.getTipo().equals("9")) {
            throw new ExceptionTipoProdutoInvalido(); //Exceção Personalizada (4)
        }
        if (produto.getValor() <= 0) {
            throw new ExceptionValorProdutoInvalido();  //Exceção Personalizada (5)
        }
        try {
            String codigo = String.format("%06d", produto.getCodigo());
            String flag = "*";
            String tipo = "9".equals(produto.getTipo()) ? "0" : "6"; // 9 para peso, 6 para unidade
            String descricao = String.format("%-20s", produto.getDescricao());
            String preco = String.format("%09.2f", produto.getValor()).replace(".", ",");

            return codigo + flag + tipo + descricao + preco + "00000D";
        } catch (NumberFormatException e) { //Exceção Nativa(2)
            throw new NumberFormatException("Erro ao formatar os valores do produto.");
        }
    }
}
