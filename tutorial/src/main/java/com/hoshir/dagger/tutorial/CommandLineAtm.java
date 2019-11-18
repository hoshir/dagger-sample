package com.hoshir.dagger.tutorial;

import java.util.Scanner;

public class CommandLineAtm {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    CommandProcessorFactory commandProcessorFactory = DaggerCommandProcessorFactory.create();
    CommandProcessor router = commandProcessorFactory.processor();
    System.out.println("");

    while (scanner.hasNextLine()) {
      router.process(scanner.nextLine());
    }
  }
}
