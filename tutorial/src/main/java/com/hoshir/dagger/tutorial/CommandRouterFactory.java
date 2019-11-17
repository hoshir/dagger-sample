package com.hoshir.dagger.tutorial;

import dagger.Component;

@Component
public interface CommandRouterFactory {
  CommandRouter router();
}
