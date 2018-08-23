package com.hoshir.dagger;

public class Main {

  public static void main(String[] args) {

    ChatApp app = new ChatApp(new HelloBot());

    app.run();
  }
}
