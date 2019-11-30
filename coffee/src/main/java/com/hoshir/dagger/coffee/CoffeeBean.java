package com.hoshir.dagger.coffee;

import com.hoshir.dagger.coffee.Coffee.Roast;
import org.immutables.value.Value;

@Value.Immutable
interface CoffeeBean {
  String getCountry();

  String getFarmer();

  Roast getRoast();
}
