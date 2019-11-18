package com.hoshir.dagger.tutorial;

import com.hoshir.dagger.tutorial.Database.Account;

import javax.inject.Inject;
import java.math.BigDecimal;
import java.util.List;

public final class DepositCommand implements Command {
  private Account account;
  private Outputter outputter;

  @Inject
  DepositCommand(Account account, Outputter outputter) {
    this.account = account;
    this.outputter = outputter;
  }

  @Override
  public Result handleInput(List<String> input) {
    if (input.size() != 1) {
      return Result.invalid();
    }

    account.deposit(new BigDecimal(input.get(0)));
    outputter.output(account.username() + " now has: " + account.balance());

    return Result.handled();
  }
}
