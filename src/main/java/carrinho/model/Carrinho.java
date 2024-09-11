package carrinho.model;
import java.util.ArrayList;
import java.util.List;
public class Carrinho {
   float acrescimoTotal;
   float descontoTotal;
   float valorTotal;
   private List<Item> itens = new ArrayList<>();
   public void inserir(Item item){
         this.itens.add(item);
   }
   public void acrescimoItem(Integer codigo, double acrescimo){
         for(Item item: itens){
            if(item.getCodigo() ==  codigo){
               double novoPreco = item.getPreco() + acrescimo;
               item.setPreco(novoPreco);
               double novoAcrescimo = item.getAcrescimo() + acrescimo;
               item.setAcrescimo(novoAcrescimo);

               System.out.println("Acréscimo de R$ " + acrescimo + " Novo preço do item: " + novoPreco
               );
            }
         }
   }
   public void descontoItem(Integer codigo, double desconto){
      for(Item item : itens){
         if(item.getCodigo() == codigo && desconto< item.getPreco()){
            double novoPreco = item.getPreco() - desconto;
            item.setPreco(novoPreco);
            double novoDesconto = item.getDesconto() + desconto;
            item.setDesconto(novoDesconto);

            System.out.println("Desconto de R$ " + desconto + " Novo preço do item: " + novoPreco
            );
         }
      }
   }
   public void acrescimoTotal(double acrescimoTotal){
      int tamanho = itens.size();
      double distribuirPorItem = acrescimoTotal/tamanho;

      for(Item item : itens){
         double novoPreco = item.getPreco() + distribuirPorItem;
         item.setPreco(novoPreco);
         double atualizarAcrescimo = item.getAcrescimo() + distribuirPorItem;
         item.setAcrescimo(atualizarAcrescimo);

         System.out.println("Acrescimo de R$ " + distribuirPorItem + " Novo preço: " + novoPreco
         );
      }
   }
   public void descontoTotal(double descontoTotal){
      int tamanho = itens.size();
      double distribuirPorItem = descontoTotal/tamanho;

      for (Item item : itens){
         if( distribuirPorItem < item.getPreco()){
            double novoPreco = item.getPreco() - distribuirPorItem;
            item.setPreco(novoPreco);
            double atualizarDesconto = item.getDesconto() + distribuirPorItem;
            item.setDesconto(atualizarDesconto);

            System.out.println("Desconto de R$ " + distribuirPorItem + " Novo preço: " + novoPreco
            );
         }
      }
   }
   public void finalizarVenda(){
      for(Item item : itens){
         acrescimoTotal += item.getAcrescimo();
         descontoTotal += item.getDesconto();
         valorTotal += item.getPreco();
         System.out.println(item.toString());

      }
      System.out.println("Acrescimo Total: " + acrescimoTotal);
      System.out.println("Desconto Total: " + descontoTotal);
      System.out.println("Valor Total: " + valorTotal);

   }
}
