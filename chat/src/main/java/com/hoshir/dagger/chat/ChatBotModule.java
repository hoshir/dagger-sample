package com.hoshir.dagger.chat;

import dagger.Module;
import dagger.Provides;

@Module
public class ChatBotModule {

  @Provides
  public static Bot provideBot() {
    return new HiBot();
  }
}
