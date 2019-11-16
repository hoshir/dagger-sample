package com.hoshir.dagger.chat;

public class Main {

  public static void main(String[] args) {

    ChatBot chatBot = DaggerChatBot.builder().build();
    ChatApp app = new ChatApp(chatBot.bot());

    app.run();
  }
}
