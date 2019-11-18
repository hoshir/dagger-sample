package com.hoshir.dagger.tutorial;

import com.hoshir.dagger.tutorial.Database.Account;
import dagger.Binds;
import dagger.BindsOptionalOf;
import dagger.Module;
import dagger.multibindings.IntoMap;
import dagger.multibindings.StringKey;

@Module
interface LoginCommandModule {
  @Binds
  @IntoMap
  @StringKey("login")
  abstract Command loginCommand(LoginCommand command);

  @BindsOptionalOf
  Account optionalAccount();
}
