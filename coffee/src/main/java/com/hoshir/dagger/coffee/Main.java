package com.hoshir.dagger.coffee;

public class Main {
  public static void main(String[] args) {
    CoffeeShop shop = DaggerCoffeeShopFactory.create().shop();

    Coffee regular = shop.regular();
    System.out.println(regular.brew());

    Coffee special = shop.todaysSpecial();
    System.out.println(special.brew());
  }
}
