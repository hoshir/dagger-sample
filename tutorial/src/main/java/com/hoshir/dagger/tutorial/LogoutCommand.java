package com.hoshir.dagger.tutorial;

import com.hoshir.dagger.tutorial.Database.Account;

import javax.inject.Inject;
import java.util.List;

public final class LogoutCommand implements Command {
  private Account account;
  private Outputter outputter;

  @Inject
  LogoutCommand(Account account, Outputter outputter) {
    this.account = account;
    this.outputter = outputter;
  }

  @Override
  public Result handleInput(List<String> input) {
    if (!input.isEmpty()) {
      return Result.invalid();
    }
    outputter.output("logged out " + account.username());

    return Result.inputCompleted();
  }
}
