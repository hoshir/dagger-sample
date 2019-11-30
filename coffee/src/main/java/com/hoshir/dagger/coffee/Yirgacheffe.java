package com.hoshir.dagger.coffee;

import com.hoshir.dagger.coffee.Coffee.Roast;

import javax.inject.Inject;

class Yirgacheffe implements CoffeeBean {
  @Inject
  public Yirgacheffe() {
  }

  @Override
  public String getCountry() {
    return "Ethiopia";
  }

  @Override
  public String getFarmer() {
    return "Yirgacheffe";
  }

  @Override
  public Roast getRoast() {
    return Roast.MEDIUM;
  }
}
