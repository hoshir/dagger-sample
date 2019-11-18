package com.hoshir.dagger.tutorial;

import java.util.Scanner;

public class CommandLineAtm {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    CommandRouterFactory commandRouterFactory = DaggerCommandRouterFactory.create();
    CommandRouter router = commandRouterFactory.router();
    System.out.println("");

    while (scanner.hasNextLine()) {
      router.route(scanner.nextLine());
    }
  }
}