package com.hoshir.dagger.tutorial;

import javax.inject.Inject;
import java.math.BigDecimal;

@PerSession
public class WithdrawalLimiter {
  private BigDecimal remainingWithdrawalLimit;

  @Inject
  WithdrawalLimiter(@MaxWithdrawal BigDecimal maxWithdrawal) {
    this.remainingWithdrawalLimit = maxWithdrawal;
  }

  void recordDeposit(BigDecimal amount) {
    remainingWithdrawalLimit = remainingWithdrawalLimit.add(amount);
  }

  void recordWithdrawal(BigDecimal amount) {
    remainingWithdrawalLimit = remainingWithdrawalLimit.subtract(amount);
  }

  BigDecimal remainingWithdrawalLimit() {
    return remainingWithdrawalLimit;
  }
}
