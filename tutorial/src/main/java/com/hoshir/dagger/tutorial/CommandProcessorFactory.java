package com.hoshir.dagger.tutorial;

import dagger.Component;

import javax.inject.Singleton;

@Component(
    modules = {
      HelloWorldCommandModule.class,
      UserCommandsRouter.InstallationModule.class,
      SystemOutModule.class,
      LoginCommandModule.class,
    })
@Singleton
interface CommandProcessorFactory {
  CommandProcessor processor();
}
