package com.hoshir.dagger.tutorial;

import com.hoshir.dagger.tutorial.Database.Account;

import javax.inject.Inject;
import java.math.BigDecimal;
import java.util.List;

public final class WithdrawCommand implements Command {
  private Account account;
  private Outputter outputter;
  private BigDecimal minimumBalance;
  private BigDecimal maximumWithdrawal;

  @Inject
  WithdrawCommand(
      Account account,
      Outputter outputter,
      @MinBalance BigDecimal minimumBalance,
      @MaxBalance BigDecimal maximumWithdrawal) {
    this.account = account;
    this.outputter = outputter;
    this.minimumBalance = minimumBalance;
    this.maximumWithdrawal = maximumWithdrawal;
  }

  @Override
  public Result handleInput(List<String> input) {
    if (input.size() != 1) {
      return Result.invalid();
    }

    BigDecimal amount = new BigDecimal(input.get(0));
    if (amount.compareTo(maximumWithdrawal) > 0) {
      return Result.invalid();
    }

    BigDecimal newBalance = account.balance().subtract(amount);
    if (newBalance.compareTo(minimumBalance) < 0) {
      return Result.invalid();
    } else {
      account.withdraw(amount);
      outputter.output("your new balance is: " + account.balance());
      return Result.handled();
    }
  }
}
