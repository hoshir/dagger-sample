package com.hoshir.dagger.coffee;

import javax.inject.Inject;

public class Coffee {
  public enum Roast {
    MEDIUM("Medium roast"),
    CITY("City roast");

    private final String name;

    Roast(String name) {
      this.name = name;
    }

    @Override
    public String toString() {
      return name;
    }
  }

  private CoffeeBean bean;

  @Inject
  public Coffee(CoffeeBean bean) {
    this.bean = bean;
  }

  public String brew() {
    return String.format(
        "Today's coffee: %s/%s %s", bean.getCountry(), bean.getFarmer(), bean.getRoast());
  }
}
