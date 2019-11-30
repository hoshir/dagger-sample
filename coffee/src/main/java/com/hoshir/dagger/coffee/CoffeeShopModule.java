package com.hoshir.dagger.coffee;

import dagger.Module;

@Module(subcomponents = {RegularCoffeeModule.RegularCoffeeComponent.class, TodaysSpecialModule.TodaysSpecialComponent.class})
interface CoffeeShopModule {
}
