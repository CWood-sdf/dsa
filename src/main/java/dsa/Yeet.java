package dsa;

import java.util.*;

class YeetIterator implements Iterator<String> {
  public int i = 0;

  @Override
  public boolean hasNext() {
    return i <= 1;
  }

  @Override
  public String next() {
    if (i == 0) {
      i++;
      return "sdf";
    }
    if (i == 1) {
      i++;
      return "asdf";
    }
    i++;
    return "urmom";
  }

  public YeetIterator() {}
}

class Yeet implements Iterable<String> {
  @Override
  public YeetIterator iterator() {
    return new YeetIterator();
  }
}
