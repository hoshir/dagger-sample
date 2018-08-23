package com.hoshir.dagger;

import javax.inject.Inject;

public class ChatApp {
  private Bot bot;

  @Inject
  public ChatApp(Bot bot) {
    this.bot = bot;
  }

  public void run() {
    System.out.println(bot.say());
  }
}
