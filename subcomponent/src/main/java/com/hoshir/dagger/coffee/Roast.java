package com.hoshir.dagger.coffee;

public enum Roast {
  LIGHT("Light roast"),
  CINNAMON("Cinnamon roast"),
  MEDIUM("Medium roast"),
  HIGH("High roast"),
  CITY("City roast"),
  FULL_CITY("Full City roast"),
  FRENCH("French roast"),
  ITALIAN("Light roast");

  private final String name;

  Roast(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return name;
  }
}
