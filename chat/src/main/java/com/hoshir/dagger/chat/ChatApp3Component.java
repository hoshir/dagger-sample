package com.hoshir.dagger.chat;

import dagger.Component;

@Component(modules = ChatApp3Module.class)
interface ChatApp3Component {
  ChatApp3.Factory factory();
}
