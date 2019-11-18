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
  public Result handleInput(List<String> input) {
    if (!input.isEmpty()) {
      return Result.invalid();
    }
    outputter.output("world!");

    return Result.handled();
  }
}
