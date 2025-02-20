import java.util.*;
import java.util.concurrent.*;

public class CallableTestClass implements Callable<Integer> {

  private final Integer number;

  public CallableTestClass(Integer number) {
    this.number = number;

  }

  @Override
  public Integer call() throws Exception {
    System.out.println("implemented callable!");
    Thread.sleep(4000);
    return this.number;
  }

}
