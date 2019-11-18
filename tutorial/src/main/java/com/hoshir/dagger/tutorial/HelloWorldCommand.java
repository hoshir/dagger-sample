package com.hoshir.dagger.tutorial;

import javax.inject.Inject;
import java.util.List;

public final class HelloWorldCommand implements Command {
  private Outputter outputter;

  @Inject
  HelloWorldCommand(Outputter outputter) {
    this.outputter = outputter;
  }

  @Override
  public String key() {
    return "hello";
  }

  @Override
  public Status handleInput(List<String> input) {
    if (!input.isEmpty()) {
      return Status.INVALID;
    }
    outputter.outputs("world!");

    return Status.HANDLED;
  }
}
