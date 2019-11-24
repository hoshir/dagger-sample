package com.hoshir.dagger.chat;

import dagger.Component;

@Component(modules = ChatApp2Module.class)
interface ChatApp2Component {
  ChatApp2.Factory factory();
}
