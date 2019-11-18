package com.hoshir.dagger.tutorial;

import dagger.Component;

import javax.inject.Singleton;

@Component(
    modules = {
      HelloWorldCommandModule.class,
      SystemOutModule.class,
      LoginCommandModule.class,
      DepositCommandModule.class
    })
@Singleton
interface CommandRouterFactory {
  CommandRouter router();
}
