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
  private WithdrawalLimiter withdrawalLimiter;

  @Inject
  WithdrawCommand(
      Account account,
      Outputter outputter,
      @MinBalance BigDecimal minimumBalance,
      @MaxWithdrawal BigDecimal maximumWithdrawal,
      WithdrawalLimiter withdrawalLimiter) {
    this.account = account;
    this.outputter = outputter;
    this.minimumBalance = minimumBalance;
    this.maximumWithdrawal = maximumWithdrawal;
    this.withdrawalLimiter = withdrawalLimiter;
  }

  @Override
  public Result handleInput(List<String> input) {
    if (input.size() != 1) {
      return Result.invalid();
    }

    BigDecimal amount = new BigDecimal(input.get(0));
    BigDecimal remainingWithdrawalLimit = withdrawalLimiter.remainingWithdrawalLimit();
    if (amount.compareTo(remainingWithdrawalLimit) > 0) {
      outputter.output(
          String.format(
              "you may not withdraw %s; you may withdraw %s more in this session",
              amount, remainingWithdrawalLimit));
      return Result.invalid();
    }

    BigDecimal newBalance = account.balance().subtract(amount);
    if (newBalance.compareTo(minimumBalance) < 0) {
      outputter.output(
          String.format(
              "you don't have sufficient funds to withdraw %s. "
                  + "your balance is %s and the minimum balance is %s",
              amount, account.balance(), minimumBalance));
      return Result.invalid();
    } else {
      account.withdraw(amount);
      withdrawalLimiter.recordWithdrawal(amount);
      outputter.output("your new balance is: " + account.balance());
      return Result.handled();
    }
  }
}
