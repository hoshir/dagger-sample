package com.hoshir.dagger.subcomponent;

class Daterra implements CoffeeBean {
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
