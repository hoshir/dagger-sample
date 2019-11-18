package com.hoshir.dagger.tutorial;

import com.hoshir.dagger.tutorial.Command.Result;
import com.hoshir.dagger.tutorial.Command.Status;

import javax.inject.Inject;
import java.util.ArrayDeque;
import java.util.Deque;

public class CommandProcessor {
  private final Deque<CommandRouter> commandRouterStack = new ArrayDeque<>();

  @Inject
  CommandProcessor(CommandRouter commandRouter) {
    commandRouterStack.add(commandRouter);
  }

  Status process(String input) {
    Result result = commandRouterStack.peek().route(input);
    if (result.status().equals(Status.INPUT_COMPLETED)) {
      commandRouterStack.pop();
      return commandRouterStack.isEmpty() ? Status.INPUT_COMPLETED : Status.HANDLED;
    }

    result.nestedCommandRouter().ifPresent(commandRouterStack::push);
    return result.status();
  }
}
