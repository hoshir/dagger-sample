package com.hoshir.dagger;

/*
 * This Java source file was generated by the Gradle 'init' task.
 */
public class Main {

  public static void main(String[] args) {
    ChatApp app = new ChatApp(new HelloBot());
//    ChatApp app = new ChatApp(new HiBot());
    app.run();
  }
}
