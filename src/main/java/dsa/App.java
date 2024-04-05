package dsa;

import java.util.*;

class YeetThread implements Runnable {
  public void run() {
    try {
      Thread.sleep(1000);
    } catch (Exception e) {

    }
    System.out.println("ur mom");
  }
}

class Sdf {
  // @Override
  // public boolean equals(Object right) {
  //   if (right instanceof Sdf) {
  //     return true;
  //   }
  //   return false;
  // }
}

/** Hello world! */
public class App {
  public static void main(String[] args) {
    Thread yeet1 = new Thread(new YeetThread());
    Thread yeet2 = new Thread(new YeetThread());
    yeet1.start();
    yeet2.start();
    System.out.println(Objects.hashCode("sdfsdf") % 10);
    System.out.println("Hello World!");
    List<String> x = new LinkedList<String>();

    Sdf left = new Sdf();
    Sdf right = new Sdf();
    System.out.println(left.equals(right));

    x.add("sdf");
    x.add("urmom");

    System.out.println(x);
    Yeet yeet = new Yeet();

    for (String s : yeet) {
      System.out.println(s);
    }
  }
}
