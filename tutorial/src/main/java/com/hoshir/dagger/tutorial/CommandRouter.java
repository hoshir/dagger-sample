package com.hoshir.dagger.tutorial;

import com.hoshir.dagger.tutorial.Command.Status;

import javax.inject.Inject;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

final class CommandRouter {
  private final Map<String, Command> commands = new HashMap<>();

  @Inject
  CommandRouter(Command command) {
    commands.put(command.key(), command);
  }

  Status route(String input) {
    List<String> splitInput = split(input);
    if (splitInput == null) {
      return invalidCommand(input);
    }

    String commandKey = splitInput.get(0);
    Command command = commands.get(commandKey);
    if (command == null) {
      return invalidCommand(input);
    }

    Status status = command.handleInput(splitInput.subList(1, splitInput.size()));
    if (status == Status.INVALID) {
      System.out.println(commandKey + ": invalid arguments");
    }
    return status;
  }

  private Status invalidCommand(String input) {
    System.out.println(String.format("couldn't understand \"%s\". please try again.", input));
    return Status.INVALID;
  }

  private static List<String> split(String str) {
    return Arrays.asList(str.split(" "));
  }
}
