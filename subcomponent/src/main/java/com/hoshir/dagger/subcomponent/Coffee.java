package com.hoshir.dagger.subcomponent;

public class Coffee {
  private CoffeeBean coffeeBean;

  public Coffee(CoffeeBean coffeeBean) {
    this.coffeeBean = coffeeBean;
  }

  public String pour() {
    return String.format(
        "Today's coffee: %s/%s %s",
        coffeeBean.getCountryName(), coffeeBean.getFarmer(), coffeeBean.getRoast());
  }
}
