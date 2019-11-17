package com.hoshir.dagger.tutorial;

import java.util.List;

interface Command {
  String key();

  Status handleInput(List<String> input);

  enum Status {
    INVALID,
    HANDLED,
  }
}
