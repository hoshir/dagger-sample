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
  CoffeeBean daterra() {
    return new Daterra();
  }
}
