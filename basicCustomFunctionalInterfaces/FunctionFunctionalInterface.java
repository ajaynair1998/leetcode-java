package basicCustomFunctionalInterfaces;

import java.util.function.Function;

public class FunctionFunctionalInterface implements Function<String, Integer> {
  @Override
  public Integer apply(String t) {
    // TODO Auto-generated method stub
    return t.length();
  }

}
