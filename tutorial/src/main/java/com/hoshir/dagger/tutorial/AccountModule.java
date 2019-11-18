package com.hoshir.dagger.tutorial;

import com.hoshir.dagger.tutorial.Database.Account;
import dagger.Module;
import dagger.Provides;

@Module
interface AccountModule {
  @Provides
  static Account account(Database database, @Username String username) {
    return database.getAccount(username);
  }
}
