package com.hoshir.dagger.chat;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

@Module
interface ChatApp3Module {

  @Binds
  ChatApp3.Factory chatApp3Factory(ChatApp3Factory factory);

  @Provides
  static Bot provideBot() {
    return new HelloBot();
  }
}
