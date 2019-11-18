package com.hoshir.dagger.tutorial;

import dagger.Module;
import dagger.Provides;

import java.math.BigDecimal;

@Module
abstract class AmountsModule {
  @Provides
  @MinBalance
  static BigDecimal minBalance() {
    return BigDecimal.ZERO;
  }

  @Provides
  @MaxWithdrawal
  static BigDecimal maxWithdrawal() {
    return new BigDecimal(1000);
  }
}
