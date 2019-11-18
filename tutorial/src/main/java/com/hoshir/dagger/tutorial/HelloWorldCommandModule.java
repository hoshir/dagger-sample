package com.hoshir.dagger.tutorial;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;
import dagger.multibindings.StringKey;

@Module
abstract class HelloWorldCommandModule {
  @Binds
  @IntoMap
  @StringKey("hello")
  abstract Command helloWorldCommand(HelloWorldCommand command);
}
