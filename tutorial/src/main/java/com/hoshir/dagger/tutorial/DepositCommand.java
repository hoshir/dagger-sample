package com.hoshir.dagger.tutorial;

import com.hoshir.dagger.tutorial.Database.Account;

import javax.inject.Inject;
import java.math.BigDecimal;
import java.util.List;

public final class DepositCommand implements Command {
  private Database database;
  private Outputter outputter;

  @Inject
  DepositCommand(Database database, Outputter outputter) {
    this.database = database;
    this.outputter = outputter;
  }

  @Override
  public Result handleInput(List<String> input) {
    if (input.size() != 2) {
      return Result.invalid();
    }

    Account account = database.getAccount(input.get(0));
    account.deposit(new BigDecimal(input.get(1)));
    outputter.output(account.username() + " now has: " + account.balance());

    return Result.handled();
  }
}
