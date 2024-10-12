package ThreadsFinanceiro.Main;
import ThreadsFinanceiro.Model.LerDespesas;
import ThreadsFinanceiro.Model.LerProvisao;
import ThreadsFinanceiro.Model.LerReceitas;
import ThreadsFinanceiro.Model.WorkerBarrier;

import java.util.concurrent.CyclicBarrier;
public class main {
    public static void main(String[] args) {
        final int NUM_THREADS = 3;

        CyclicBarrier barrier = new CyclicBarrier(NUM_THREADS, () -> {
            System.out.println("Todas as threads chegaram à barreira e estão sincronizadas. Vamos continuar!");
        });

        LerDespesas lerDespesas = new LerDespesas();
        LerReceitas lerReceitas = new LerReceitas();
        Thread despesasThread = new Thread( new WorkerBarrier(barrier, lerDespesas), "Thread-Despesas");
        Thread receitasThread = new Thread(new WorkerBarrier(barrier, lerReceitas), "Thread-Receitas");
        Thread provisaoThread = new Thread(new WorkerBarrier(barrier, new LerProvisao()), "Thread-Provisão");

        despesasThread.start();
        receitasThread.start();
        provisaoThread.start();

        try {
            despesasThread.join();
            receitasThread.join();
            provisaoThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Todas as threads concluíram suas tarefas.");

        double totalReceitas = lerReceitas.getReceitasTotais();
        double totalDespesas = lerDespesas.getDespesasTotais();
        double resultadoFinal = totalReceitas - totalDespesas;
        System.out.println("Total Receitas: " + totalReceitas);
        System.out.println("Total Despesas: " + totalDespesas);
        System.out.println("Resultado Financeiro: " + resultadoFinal);


    }
}
