package com.hoshir.dagger.coffee;

public class Coffee {
  private CoffeeBean bean;

  public Coffee(CoffeeBean bean) {
    this.bean = bean;
  }

  public String pour() {
    return String.format(
        "Today's coffee: %s/%s %s", bean.getCountry(), bean.getFarmer(), bean.getRoast());
  }
}
