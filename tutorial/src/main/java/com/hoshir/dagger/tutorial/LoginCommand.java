package com.hoshir.dagger.tutorial;

import javax.inject.Inject;
import java.util.List;

public final class LoginCommand implements Command {
  private Outputter outputter;

  @Inject
  LoginCommand(Outputter outputter) {
    this.outputter = outputter;
  }

  @Override
  public String key() {
    return "login";
  }

  @Override
  public Status handleInput(List<String> input) {
    if (input.size() != 1) {
      return Status.INVALID;
    }
    String username = input.get(0);
    outputter.outputs(username + " is logged in.");

    return Status.HANDLED;
  }
}
