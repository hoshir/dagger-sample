package com.hoshir.dagger;

public class ChatApp {
  private Bot bot;

  public ChatApp(Bot bot) {
    this.bot = bot;
  }

  public void run() {
    System.out.println(bot.say());
  }
}
