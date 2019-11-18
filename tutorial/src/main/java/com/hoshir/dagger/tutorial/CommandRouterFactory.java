package com.hoshir.dagger.tutorial;

import dagger.Component;

@Component(modules = {HelloWorldModule.class, SystemOutModule.class})
interface CommandRouterFactory {
  CommandRouter router();
}
