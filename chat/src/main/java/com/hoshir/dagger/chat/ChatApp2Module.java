package com.hoshir.dagger.chat;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

@Module
interface ChatApp2Module {

  @Binds
  ChatApp2.Factory chatApp2Factory(ChatApp2Factory factory);

  @Provides
  static Bot provideBot() {
    return new HelloBot();
  }
}
