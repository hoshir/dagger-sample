package com.hoshir.dagger.tutorial;

import dagger.Component;

@Component(
    modules = {HelloWorldCommandModule.class, SystemOutModule.class, LoginCommandModule.class})
interface CommandRouterFactory {
  CommandRouter router();
}
