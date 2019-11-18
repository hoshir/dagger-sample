package com.hoshir.dagger.tutorial;

import com.hoshir.dagger.tutorial.Database.Account;

import javax.inject.Inject;
import java.math.BigDecimal;
import java.util.List;

public final class WithdrawCommand implements Command {
  private Account account;
  private Outputter outputter;

  @Inject
  WithdrawCommand(Account account, Outputter outputter) {
    this.account = account;
    this.outputter = outputter;
  }

  @Override
  public Result handleInput(List<String> input) {
    if (input.size() != 1) {
      return Result.invalid();
    }

    BigDecimal amount = new BigDecimal(input.get(0));
    BigDecimal newBalance = account.balance().subtract(amount);
    if (newBalance.signum() < 0) {
      return Result.invalid();
    } else {
      account.withdraw(amount);
      outputter.output("your new balance is: " + account.balance());
      return Result.handled();
    }
  }
}
