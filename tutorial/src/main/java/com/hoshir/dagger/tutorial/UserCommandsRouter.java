package com.hoshir.dagger.tutorial;

import com.hoshir.dagger.tutorial.Database.Account;
import dagger.BindsInstance;
import dagger.Module;
import dagger.Subcomponent;

@PerSession
@Subcomponent(modules = UserCommandsModule.class)
interface UserCommandsRouter {
  CommandRouter router();

  @Subcomponent.Factory
  interface Factory {
    UserCommandsRouter create(@BindsInstance Account account);
  }

  @Module(subcomponents = UserCommandsRouter.class)
  interface InstallationModule {};
}
