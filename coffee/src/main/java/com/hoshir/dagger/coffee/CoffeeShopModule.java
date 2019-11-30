package com.hoshir.dagger.coffee;

import dagger.Component;
import dagger.Module;

@Module(
    subcomponents = {
        RegularCoffeeModule.RegularCoffeeComponent.class,
        TodaysSpecialModule.TodaysSpecialComponent.class
    })
interface CoffeeShopModule {

  @Component(modules = CoffeeShopModule.class)
  interface CoffeeShopComponent {
    CoffeeShop shop();
  }
}
