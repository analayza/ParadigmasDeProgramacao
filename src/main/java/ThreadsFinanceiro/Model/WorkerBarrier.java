package ThreadsFinanceiro.Model;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class WorkerBarrier implements Runnable{
    private final CyclicBarrier barrier;
    private final Object leitor;

    public WorkerBarrier(CyclicBarrier barrier, Object leitor) {
        this.barrier = barrier;
        this.leitor = leitor;
    }
    @Override
    public void run() {
        try {
            if(leitor instanceof LerDespesas){
                System.out.println(((LerDespesas) leitor).despesas());
            } else if (leitor instanceof LerReceitas) {
                System.out.println(((LerReceitas) leitor).receitas());
            } else if (leitor instanceof LerProvisao) {
                System.out.println(((LerProvisao) leitor).provisao());
            }

            System.out.println(Thread.currentThread().getName() + " terminou sua tarefa e está aguardando na barreira.");
            barrier.await();

            System.out.println(Thread.currentThread().getName() + " passou da barreira e continua a execução.");
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}
