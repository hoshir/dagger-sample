package com.hoshir.dagger.coffee;

import com.hoshir.dagger.coffee.Coffee.Roast;

import javax.inject.Inject;

class Daterra implements CoffeeBean {
  @Inject
  public Daterra() {
  }

  @Override
  public String getCountry() {
    return "Brazil";
  }

  @Override
  public String getFarmer() {
    return "Daterra";
  }

  @Override
  public Roast getRoast() {
    return Roast.CITY;
  }
}