package com.hoshir.dagger;

import dagger.Component;

@Component(modules = ChatBotModule.class)
interface ChatBot {
  Bot bot();
}
