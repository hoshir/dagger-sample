package com.hoshir.dagger.chat;

public class Main {

  public static void main(String[] args) {
    ChatApp app = DaggerChatAppFactory.create().app();
    ChatApp2 app2 = DaggerChatApp2Component.create().factory().create("friends");
    ChatApp3 app3 = DaggerChatApp3Component.create().factory().create();
    app.run();
    app2.run();
    app3.run();
  }
}
