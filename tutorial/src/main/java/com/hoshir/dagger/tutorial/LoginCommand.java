package com.hoshir.dagger.tutorial;

import com.hoshir.dagger.tutorial.Database.Account;

import javax.inject.Inject;
import java.util.List;
import java.util.Optional;

public final class LoginCommand implements Command {
  private final Database database;
  private final Outputter outputter;
  private final UserCommandsRouter.Factory userCommandsFactory;
  private final Optional<Account> account;

  @Inject
  LoginCommand(
      Database database,
      Outputter outputter,
      UserCommandsRouter.Factory userCommandsFactory,
      Optional<Account> account) {
    this.database = database;
    this.outputter = outputter;
    this.userCommandsFactory = userCommandsFactory;
    this.account = account;
  }

  @Override
  public Result handleInput(List<String> input) {
    if (input.size() != 1) {
      return Result.invalid();
    }
    String username = input.get(0);

    if (account.isPresent()) {
      Result.handled();
    }

    if (account.isPresent()) {
      String loggedInUser = account.get().username();
      outputter.output(loggedInUser + " is already logged in");
      if (!loggedInUser.equals(username)) {
        outputter.output("run `logout` first before trying to log in another user");
      }
      return Result.handled();
    } else {
      UserCommandsRouter userCommands = userCommandsFactory.create(username);
      return Result.enterNestedCommandSet(userCommands.router());
    }
  }
}
