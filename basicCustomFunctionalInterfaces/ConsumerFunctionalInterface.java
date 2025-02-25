package basicCustomFunctionalInterfaces;

import java.util.function.Consumer;

public class ConsumerFunctionalInterface implements Consumer<String> {
  @Override
  public void accept(String t) {
    System.out.println(t);
  };

}
