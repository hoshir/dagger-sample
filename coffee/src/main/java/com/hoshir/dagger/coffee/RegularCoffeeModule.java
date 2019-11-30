package com.hoshir.dagger.coffee;

import dagger.Module;
import dagger.Provides;
import dagger.Subcomponent;

@Module
class RegularCoffeeModule {

  @Subcomponent(modules = RegularCoffeeModule.class)
  interface RegularCoffeeComponent {
    Coffee coffee();

    @Subcomponent.Builder
    interface Builder {
      RegularCoffeeComponent build();
    }
  }

  @Provides
  CoffeeBean coffeeBean() {
    return ImmutableCoffeeBean.builder()
        .country("Brazil")
        .farmer("Daterra")
        .roast(Coffee.Roast.CITY)
        .build();
  }
}
