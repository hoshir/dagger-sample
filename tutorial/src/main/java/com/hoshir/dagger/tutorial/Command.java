package com.hoshir.dagger.tutorial;

import java.util.List;
import java.util.Optional;

interface Command {
  Result handleInput(List<String> input);

  final class Result {
    private final Status status;
    private final Optional<CommandRouter> nestedCommandRouter;

    private Result(Status status, Optional<CommandRouter> nestedCommandRouter) {
      this.status = status;
      this.nestedCommandRouter = nestedCommandRouter;
    }

    static Result invalid() {
      return new Result(Status.INVALID, Optional.empty());
    }

    static Result handled() {
      return new Result(Status.HANDLED, Optional.empty());
    }

    static Result inputCompleted() {
      return new Result(Status.INPUT_COMPLETED, Optional.empty());
    }

    static Result enterNestedCommandSet(CommandRouter nestedCommandRouter) {
      return new Result(Status.HANDLED, Optional.of(nestedCommandRouter));
    }

    Status status() {
      return status;
    }

    Optional<CommandRouter> nestedCommandRouter() {
      return nestedCommandRouter;
    }
  }

  enum Status {
    INVALID,
    HANDLED,
    INPUT_COMPLETED,
  }
}
