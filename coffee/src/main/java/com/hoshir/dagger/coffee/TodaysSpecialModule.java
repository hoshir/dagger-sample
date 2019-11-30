package com.hoshir.dagger.coffee;

import dagger.Module;
import dagger.Provides;
import dagger.Subcomponent;

@Module
class TodaysSpecialModule {

  @Subcomponent(modules = TodaysSpecialModule.class)
  interface TodaysSpecialComponent {
    Coffee coffee();

    @Subcomponent.Builder
    interface Builder {
      TodaysSpecialComponent build();
    }
  }

  @Provides
  CoffeeBean yirgacheffe() {
    return new Yirgacheffe();
  }
}
