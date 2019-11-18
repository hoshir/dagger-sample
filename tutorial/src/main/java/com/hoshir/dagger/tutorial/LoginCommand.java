package com.hoshir.dagger.tutorial;

import com.hoshir.dagger.tutorial.Database.Account;

import javax.inject.Inject;
import java.util.List;

public final class LoginCommand implements Command {
  private Database database;
  private Outputter outputter;

  @Inject
  LoginCommand(Database database, Outputter outputter) {
    this.database = database;
    this.outputter = outputter;
  }

  @Override
  public Status handleInput(List<String> input) {
    if (input.size() != 1) {
      return Status.INVALID;
    }
    String username = input.get(0);

    Account account = database.getAccount(username);
    outputter.output(username + " is logged in with balance: " + account.balance());

    return Status.HANDLED;
  }
}
