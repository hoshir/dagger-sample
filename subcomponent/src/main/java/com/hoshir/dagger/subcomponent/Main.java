package com.hoshir.dagger.subcomponent;

public class Main {
  public static void main(String[] args) {
    Coffee coffee = new Coffee(new Daterra());

    System.out.println(coffee.pour());
  }
}
