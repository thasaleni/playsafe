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

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((amount == null) ? 0 : amount.hashCode());
    result = prime * result + ((bet == null) ? 0 : bet.hashCode());
    result = prime * result + ((name == null) ? 0 : name.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null) return false;
    if (getClass() != obj.getClass()) return false;
    Bet other = (Bet) obj;
    if (amount == null) {
      if (other.amount != null) return false;
    } else if (!amount.equals(other.amount)) return false;
    if (bet == null) {
      if (other.bet != null) return false;
    } else if (!bet.equals(other.bet)) return false;
    if (name == null) {
      if (other.name != null) return false;
    } else if (!name.equals(other.name)) return false;
    return true;
  }
}

enum Outcome {
  WIN,
  LOSE;
}
