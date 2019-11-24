package com.hoshir.dagger.chat;

import com.google.auto.factory.AutoFactory;
import com.google.auto.factory.Provided;

@AutoFactory(implementing = ChatApp2.Factory.class)
public class ChatApp2 {

  interface Factory {
    ChatApp2 create(String name);
  }

  private Bot bot;
  private String name;

  public ChatApp2(@Provided Bot bot, String name) {
    this.bot = bot;
    this.name = name;
  }

  public void run() {
    System.out.println(bot.say() + " " + name);
  }
}
