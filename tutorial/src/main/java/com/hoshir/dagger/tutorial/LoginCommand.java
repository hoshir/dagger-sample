package com.hoshir.dagger.tutorial;

import com.hoshir.dagger.tutorial.Database.Account;

import javax.inject.Inject;
import java.util.List;

public final class LoginCommand implements Command {
  private final Database database;
  private final Outputter outputter;
  private final UserCommandsRouter.Factory userCommandsRouterFactory;

  @Inject
  LoginCommand(
      Database database,
      Outputter outputter,
      UserCommandsRouter.Factory userCommandsRouterFactory) {
    this.database = database;
    this.outputter = outputter;
    this.userCommandsRouterFactory = userCommandsRouterFactory;
  }

  @Override
  public Result handleInput(List<String> input) {
    if (input.size() != 1) {
      return Result.invalid();
    }
    String username = input.get(0);

    Account account = database.getAccount(username);
    outputter.output(username + " is logged in with balance: " + account.balance());

    return Result.enterNestedCommandSet(userCommandsRouterFactory.create(account).router());
  }
}
