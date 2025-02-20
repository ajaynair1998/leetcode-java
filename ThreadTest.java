import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadTest {

  public static void main(String[] args) {
    Integer numberOfCoresOfCpu = Runtime.getRuntime().availableProcessors();
    ThreadPoolExecutor executor = new ThreadPoolExecutor(numberOfCoresOfCpu, numberOfCoresOfCpu, 60, TimeUnit.SECONDS,
        new LinkedBlockingQueue<>());

    List<Callable<Integer>> listOfOps = new ArrayList<>();

    for (Integer currentCycle = 0; currentCycle < 100; currentCycle++) {
      listOfOps.add(new CallableTestClass(currentCycle));

    }

    try {
      List<Future<Integer>> listOfFutures = executor.invokeAll(listOfOps);

      for (Future<Integer> future : listOfFutures) {
        System.out.println("Result:" + future.get());
      }
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      executor.shutdown();
    }

  }
}
