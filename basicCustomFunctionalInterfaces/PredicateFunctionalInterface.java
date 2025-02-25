package basicCustomFunctionalInterfaces;

import java.util.function.Predicate;

public class PredicateFunctionalInterface implements Predicate<Integer> {
  @Override
  public boolean test(Integer t) {
    return false;
  }

}
