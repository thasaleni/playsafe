package com.playsafe.consoleroulette;

public class Bet {
  String name;
  Double bet;
  Outcome outcome;
}

enum Outcome {
  WIN,
  LOSE;
}
