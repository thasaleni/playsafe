package com.playsafe.consoleroulette;

public class Bet {
  private String name;
  private Object bet;
  private Double amount;
  private Outcome outcome;
  private Double winnings;

  public Bet(String name, Object bet, Double amount) {
    this.name = name;
    this.bet = bet;
    this.amount = amount;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Object getBet() {
    return bet;
  }

  public void setBet(Object bet) {
    this.bet = bet;
  }

  public Double getAmount() {
    return amount;
  }

  public void setAmount(Double amount) {
    this.amount = amount;
  }

  public Outcome getOutcome() {
    return outcome;
  }

  public void setOutcome(Outcome outcome) {
    this.outcome = outcome;
  }

  public Double getWinnings() {
    return winnings;
  }

  public void setWinnings(Double winnings) {
    this.winnings = winnings;
  }
}

enum Outcome {
  WIN,
  LOSE;
}
