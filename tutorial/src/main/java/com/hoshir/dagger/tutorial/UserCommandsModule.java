package com.hoshir.dagger.tutorial;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;
import dagger.multibindings.StringKey;

@Module
interface UserCommandsModule {
  @Binds
  @IntoMap
  @StringKey("deposit")
  abstract Command depositCommand(DepositCommand command);

  @Binds
  @IntoMap
  @StringKey("withdraw")
  abstract Command withdrawCommand(WithdrawCommand command);
}
