package com.hoshir.dagger.coffee;

import javax.inject.Inject;
import javax.inject.Provider;

public class CoffeeShop {
  private Provider<RegularCoffeeModule.RegularCoffeeComponent.Builder> regularCoffeeProvider;
  private Provider<TodaysSpecialModule.TodaysSpecialComponent.Builder> todaysSpecialProvider;

  @Inject
  public CoffeeShop(
      Provider<RegularCoffeeModule.RegularCoffeeComponent.Builder> regularCoffeeProvider,
      Provider<TodaysSpecialModule.TodaysSpecialComponent.Builder> todaysSpecialProvider) {
    this.regularCoffeeProvider = regularCoffeeProvider;
    this.todaysSpecialProvider = todaysSpecialProvider;
  }

  public Coffee regular() {
    return regularCoffeeProvider.get().build().coffee();
  }

  public Coffee todaysSpecial() {
    return todaysSpecialProvider.get().build().coffee();
  }
}
