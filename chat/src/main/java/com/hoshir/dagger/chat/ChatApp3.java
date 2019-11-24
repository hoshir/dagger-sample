package com.hoshir.dagger.chat;

import com.google.auto.factory.AutoFactory;
import com.google.auto.factory.Provided;

@AutoFactory(implementing = ChatApp3.Factory.class)
public class ChatApp3 {

  interface Factory {
    ChatApp3 create(String name);

    default ChatApp3 create() {
      return create("guys");
    }
  }

  private Bot bot;
  private String name;

  public ChatApp3(@Provided Bot bot, String name) {
    this.bot = bot;
    this.name = name;
  }

  public void run() {
    System.out.println(bot.say() + " " + name);
  }
}
