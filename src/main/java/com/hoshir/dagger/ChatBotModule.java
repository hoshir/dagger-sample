package com.hoshir.dagger;

import dagger.Module;
import dagger.Provides;

@Module
public class ChatBotModule {

  @Provides
  public static Bot provideBot() {
    return new HiBot();
  }
}
