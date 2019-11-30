package com.hoshir.dagger.coffee;

public class Main {
  public static void main(String[] args) {
    CoffeeShop shop = DaggerCoffeeShopModule_CoffeeShopComponent.create().shop();

    Coffee regular = shop.regular();
    System.out.println(regular.brew());

    Coffee todaysSpecial = shop.todaysSpecial();
    System.out.println(todaysSpecial.brew());
  }
}
