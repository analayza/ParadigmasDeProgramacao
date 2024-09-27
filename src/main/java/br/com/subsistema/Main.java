package br.com.subsistema;

import br.com.subsistema.factory.ImpostoFactory;
import br.com.subsistema.factory.TipoImposto;
import br.com.subsistema.imposto.Imposto;
import br.com.subsistema.model.Item;
import br.com.subsistema.model.Produto;
import br.com.subsistema.model.Servico;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Imposto impostoICMS = new ImpostoFactory().getImposto(TipoImposto.TIPOICMS);
        Imposto impostoIPI = new ImpostoFactory().getImposto(TipoImposto.TIPOIPI);
        Imposto impostoISS = new ImpostoFactory().getImposto(TipoImposto.TIPOISS);
        Imposto impostoPIS = new ImpostoFactory().getImposto(TipoImposto.TIPOPIS);

        Produto produto1 = new Produto();
        produto1.setCodigo(1);
        produto1.setDescricao("Refrigerante de Laranja");
        produto1.setValor(7);
        produto1.setIndustrial(true);
        produto1.setImpostoCalculado(impostoICMS.calcular(produto1));
        produto1.setTotal(produto1.getValor() + produto1.getImpostoCalculado());

        Produto produto2 = new Produto();
        produto2.setCodigo(2);
        produto2.setDescricao("Refrigerante de Uva");
        produto2.setValor(6);
        produto2.setIndustrial(false);
        produto2.setImpostoCalculado(impostoICMS.calcular(produto2));
        produto2.setTotal(produto2.getValor() + produto2.getImpostoCalculado());

        Produto produto3 = new Produto();
        produto3.setCodigo(3);
        produto3.setDescricao("Kapo Sabor Morango");
        produto3.setValor(2);
        produto3.setIndustrial(false);
        produto3.setImpostoCalculado(impostoIPI.calcular(produto3));
        produto3.setTotal(produto3.getValor() + produto3.getImpostoCalculado());

        Produto produto4 = new Produto();
        produto4.setCodigo(4);
        produto4.setDescricao("Sorvete de Pavê");
        produto4.setValor(20);
        produto4.setIndustrial(false);
        produto4.setImpostoCalculado(impostoPIS.calcular(produto4));
        produto4.setTotal(produto4.getValor() + produto4.getImpostoCalculado());

        Servico servico = new Servico();
        servico.setCodigo(2);
        servico.setDescricao("Instalação de Refrigerador");
        servico.setValor(230);
        servico.setImpostoCalculado(impostoISS.calcular(servico));
        servico.setTotal(servico.getValor() + servico.getImpostoCalculado());

        List<Item> lista = new ArrayList<>();
        lista.add(produto1);
        lista.add(produto2);
        lista.add(produto3);
        lista.add(produto4);
        lista.add(servico);

        double valorTotalItensProdutoImposto = 0;
        double valorTotalItensServicoImposto = 0;
        double valorTotal= 0;


        for(int i =0; i< lista.size(); i++){
            System.out.println(lista.get(i).toString());

            if(lista.get(i) instanceof Servico){
                valorTotalItensServicoImposto += lista.get(i).getImpostoCalculado();
            }
            else if(lista.get(i) instanceof Produto){
                valorTotalItensProdutoImposto += lista.get(i).getImpostoCalculado();
            }

            valorTotal += lista.get(i).getTotal();
        }

        System.out.println("Valor total: " + valorTotal);
        System.out.println("Valor total dos impostos dos Produtos: " + valorTotalItensProdutoImposto);
        System.out.println("Valor total dos impostos dos Serviços: " + valorTotalItensServicoImposto);
    }
}
