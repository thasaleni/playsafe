package com.playsafe.consoleroulette;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.Duration;
import java.time.Instant;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import org.apache.commons.lang3.math.NumberUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.playsafe.conversion.rest.ConversionController;

public class ConsoleRoulette {
  private static final Logger LOGGER = LoggerFactory.getLogger(ConversionController.class);

  public static void main(String[] args) {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    try {
      System.out.println(
          "please enter bet in format name bet amount, eg. Tiki_Monkey 2 1.0  and press Enter\n");
      String[] betSplit = reader.readLine().split(" ");
      Bet bet =
          new Bet(betSplit[0], betSplit[1], Double.parseDouble(betSplit[2]));
      Instant start = Instant.now();
      Set<Bet> bets = new HashSet<Bet>();
      bets.add(bet);
      while (bet != null && bet.getName() != null) {
        if (Duration.between(start, Instant.now()).getSeconds() >= 30) {
          start = Instant.now();
          int result = new Random().nextInt(36 - 0 + 1) + 0;
          for (Bet playedBet : bets) {
            if ((NumberUtils.isParsable(playedBet.getBet().toString())
                && result == Integer.parseInt(playedBet.getBet().toString()))) {
              playedBet.setOutcome(Outcome.WIN);
              playedBet.setWinnings(36 *  playedBet.getAmount());
            } else if (playedBet.getBet().getClass().equals(String.class)) {
              if (playedBet.getBet().toString().equalsIgnoreCase("EVEN") && result % 2 == 0) {
                playedBet.setOutcome(Outcome.WIN);
                playedBet.setWinnings(playedBet.getAmount() * 2);
              } else if (playedBet.getBet().toString().equalsIgnoreCase("ODD") && result % 2 != 0) {
                playedBet.setWinnings(playedBet.getAmount() * 2);
                playedBet.setOutcome(Outcome.WIN);
              } else {
                playedBet.setWinnings(0.0);
                playedBet.setOutcome(Outcome.LOSE);
              }
            } else {
              playedBet.setWinnings(0.0);
              playedBet.setOutcome(Outcome.LOSE);
            }
            bets.add(playedBet);
          }
          System.out.println(String.format("NUMBER: %d", result));
          System.out.println(String.format("Player\tBet\tOutcome\tWinnings"));
          for (Bet playedBet : bets) {
            System.out.println(
                String.format(
                    "%s\t%s\t%s\t%2f",
                    playedBet.getName(),
                    playedBet.getBet(),
                    playedBet.getOutcome().toString(),
                    playedBet.getWinnings()));
          }

          bets = new HashSet<Bet>();
        }
        System.out.println(
            "please enter bet in format name bet amount, eg. Tiki_Monkey 2 1.0 and press Enter\n");
        betSplit = reader.readLine().split(" ");
        bet =
            new Bet(betSplit[0], betSplit[1], Double.parseDouble(betSplit[2]));
        bets.add(bet);
      }

    } catch (IOException e) {
      LOGGER.debug(e.getMessage());
    }
  }
}
