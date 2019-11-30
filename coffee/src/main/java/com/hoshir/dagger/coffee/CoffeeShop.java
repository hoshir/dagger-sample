package com.hoshir.dagger.coffee;

import javax.inject.Inject;
import javax.inject.Provider;

public class CoffeeShop {
  private Provider<RegularCoffeeModule.RegularCoffeeComponent.Builder> regularProvider;
  private Provider<TodaysSpecialModule.TodaysSpecialComponent.Builder> todaysSpecialProvider;

  @Inject
  public CoffeeShop(
      Provider<RegularCoffeeModule.RegularCoffeeComponent.Builder> regularProvider,
      Provider<TodaysSpecialModule.TodaysSpecialComponent.Builder> todaysSpecialProvider) {
    this.regularProvider = regularProvider;
    this.todaysSpecialProvider = todaysSpecialProvider;
  }

  public Coffee regular() {
    return regularProvider.get().build().coffee();
  }

  public Coffee todaysSpecial() {
    return todaysSpecialProvider.get().build().coffee();
  }
}
