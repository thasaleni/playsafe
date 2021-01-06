package com.playsafe.consoleroulette;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.playsafe.conversion.rest.ConversionController;

public class ConsoleRoulette {
  private static final Logger LOGGER = LoggerFactory.getLogger(ConversionController.class);

  public static void main(String[] args) {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    System.out.println("please enter player file path.\n");
    try {
      String path = reader.readLine();
      File pathFile = new File(path);
      if (path != null && pathFile.exists() && pathFile.canRead()) {
        Stream<String> stream = Files.lines(Paths.get(path));
        System.out.println("please enter bet in format name bet amount, eg. Tiki_Monkey 2 1.0 \n");
        String[] betSplit = reader.readLine().split(" ");
        Bet bet =
            new Bet(betSplit[0], Double.parseDouble(betSplit[1]), Double.parseDouble(betSplit[2]));
        Instant start = Instant.now();
        List<Bet> bets = new ArrayList<Bet>();
        while (bet != null && bet.getName() != null) {
          bets.add(bet);
          if (Duration.between(start, Instant.now()).getSeconds() >= 30) {
            start = Instant.now();
            int result = new Random().nextInt(36 - 0 + 1) + 0;
            for (Bet playedBet : bets) {
              if ((playedBet.getBet().getClass().isInstance(Integer.class)
                  && result == (Integer) playedBet.getBet())) {
                playedBet.setOutcome(Outcome.WIN);
                playedBet.setAmount(36.0 * (Integer) playedBet.getBet());
              } else if (playedBet.getBet().getClass().isInstance(String.class)) {
                if (playedBet.getBet().toString().equalsIgnoreCase("EVEN") && result % 2 == 0) {
                  playedBet.setOutcome(Outcome.WIN);
                  playedBet.setAmount((Integer) playedBet.getBet() * 2.0);
                } else if (playedBet.getBet().toString().equalsIgnoreCase("ODD")
                    && result % 2 != 0) {
                  playedBet.setAmount((Integer) playedBet.getBet() * 2.0);
                  playedBet.setOutcome(Outcome.WIN);
                } else {
                  playedBet.setOutcome(Outcome.LOSE);
                }
              } else {
                playedBet.setOutcome(Outcome.LOSE);
              }

              System.out.println(String.format("NUMBER: %d", result));
              System.out.println("Player     Bet      Outcome     Winnings");
              System.out.println(
                  String.format(
                      "%s     %d      %s     %d",
                      playedBet.getName(),
                      playedBet.getBet(),
                      playedBet.getOutcome(),
                      playedBet.getWinnings()));
            }

            bets = new ArrayList<Bet>();
          }
          reader.readLine().split(" ");
          bet =
              new Bet(
                  betSplit[0], Double.parseDouble(betSplit[1]), Double.parseDouble(betSplit[2]));
        }
      } else {
        System.err.print(
            String.format(
                "Path: %s, is malformed, does not exist or unreadable, please check and reload.",
                pathFile.getAbsoluteFile().toString()));
      }
    } catch (IOException e) {
      LOGGER.debug(e.getMessage());
    }
  }
}
