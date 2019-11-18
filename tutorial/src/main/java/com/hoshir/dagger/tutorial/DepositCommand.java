package com.hoshir.dagger.tutorial;

import com.hoshir.dagger.tutorial.Database.Account;

import javax.inject.Inject;
import java.math.BigDecimal;
import java.util.List;

public final class DepositCommand implements Command {
  private Account account;
  private Outputter outputter;
  private WithdrawalLimiter withdrawalLimiter;

  @Inject
  DepositCommand(Account account, Outputter outputter, WithdrawalLimiter withdrawalLimiter) {
    this.account = account;
    this.outputter = outputter;
    this.withdrawalLimiter = withdrawalLimiter;
  }

  @Override
  public Result handleInput(List<String> input) {
    if (input.size() != 1) {
      return Result.invalid();
    }

    BigDecimal amount = new BigDecimal(input.get(0));
    account.deposit(amount);
    outputter.output(account.username() + " now has: " + account.balance());
    withdrawalLimiter.recordDeposit(amount);

    return Result.handled();
  }
}
