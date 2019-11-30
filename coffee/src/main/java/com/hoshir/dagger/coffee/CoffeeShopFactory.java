package com.hoshir.dagger.coffee;

import dagger.Component;

@Component(modules = CoffeeShopModule.class)
interface CoffeeShopFactory {
  CoffeeShop shop();
}
