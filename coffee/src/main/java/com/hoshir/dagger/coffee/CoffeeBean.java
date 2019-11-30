package com.hoshir.dagger.coffee;

import com.hoshir.dagger.coffee.Coffee.Roast;

interface CoffeeBean {

  String getCountry();

  String getFarmer();

  Roast getRoast();
}
