public class BasicClassWrapper {
  private boolean isValid = true;
  private Integer count = 0;

  public boolean isValid() { // Follow JavaBeans convention
    return isValid;
  }

  public void setValid(boolean value) { // Setter should be void
    isValid = value;
  }

  public Integer getCount() {
    return count;
  }

  public Integer incrementCount() {
    return ++count;
  }
}
