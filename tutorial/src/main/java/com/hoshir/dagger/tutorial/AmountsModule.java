package com.hoshir.dagger.tutorial;

import dagger.Module;
import dagger.Provides;

import javax.inject.Qualifier;
import java.lang.annotation.Retention;
import java.math.BigDecimal;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Qualifier
@Retention(RUNTIME)
@interface MinBalance {}

@Qualifier
@Retention(RUNTIME)
@interface MaxBalance {}

@Module
interface AmountsModule {
  @Provides
  @MinBalance
  static BigDecimal minBalance() {
    return BigDecimal.ZERO;
  }

  @Provides
  @MaxBalance
  static BigDecimal maxBalance() {
    return new BigDecimal(1000);
  }
}
