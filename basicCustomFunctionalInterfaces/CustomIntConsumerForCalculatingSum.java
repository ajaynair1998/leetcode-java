package basicCustomFunctionalInterfaces;

import java.util.function.IntConsumer;

public class CustomIntConsumerForCalculatingSum implements IntConsumer {
  @Override
  public void accept(int value) {
    System.out.println(value);
  }
}
