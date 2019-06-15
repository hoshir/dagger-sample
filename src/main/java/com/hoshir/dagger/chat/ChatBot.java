package com.hoshir.dagger.chat;

import dagger.Component;

@Component(modules = ChatBotModule.class)
interface ChatBot {
  Bot bot();
}
