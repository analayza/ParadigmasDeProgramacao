package calibracaoCountDownLatch.Main;

import calibracaoCountDownLatch.Model.Worker;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) throws IOException {
        long tempoInicial = System.currentTimeMillis();

        // Inicializa o CountDownLatch com o valor 3, indicando que 3 threads precisam completar suas tarefas.
        CountDownLatch latch = new CountDownLatch(3);

        Path path = Paths.get(System.getProperty("user.dir") + "\\src\\main\\java\\new_calibration_text.txt");
        List<String> calibrations = Files.readAllLines(path);

        AtomicInteger soma = new AtomicInteger(0);
        AtomicInteger count = new AtomicInteger(0);

          //Dessa forma não deu a quantidade de linhas
        //Thread worker1 = new Thread(new Worker(calibrations, soma, count, latch), "Worker-1");
        //Thread worker2 = new Thread(new Worker(calibrations, soma, count, latch), "Worker-2");
        //Thread worker3 = new Thread(new Worker(calibrations, soma, count, latch), "Worker-3");

        int totalLinhas = calibrations.size();
        int parte = totalLinhas / 3;

        //Dessa forma ficou mais correto dando as 80mil linhas
        Thread worker1 = new Thread(new Worker(calibrations.subList(0, parte), soma, count, latch), "Worker-1");
        Thread worker2 = new Thread(new Worker(calibrations.subList(parte, 2 * parte), soma, count, latch), "Worker-2");
        Thread worker3 = new Thread(new Worker(calibrations.subList(2 * parte, totalLinhas), soma, count, latch), "Worker-3");

        worker1.start();
        worker2.start();
        worker3.start();

        try {
            latch.await();
            System.out.println("Todas as threads completaram suas tarefas. Continuando...");
            System.out.println("A soma dos valores é: " + soma.get());
            System.out.println("Total de linhas processadas: " + count.get());

            long tempoFinal = System.currentTimeMillis();
            System.out.printf("%.3f ms%n", (tempoFinal - tempoInicial) / 1000d);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
