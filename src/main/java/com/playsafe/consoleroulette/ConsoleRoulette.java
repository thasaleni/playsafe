package com.playsafe.consoleroulette;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.Instant;
import java.util.Random;
import java.util.stream.Stream;

public class ConsoleRoulette {
  public static void main(String args) {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    System.out.println("please enter player file path.");
    try {
      String path = reader.readLine();
      File pathFile = new File(path);
      if (path != null && pathFile.exists() && pathFile.canRead()) {
        Stream<String> stream = Files.lines(Paths.get(path));
        System.out.println("please enter bet in format name bet amount, eg. Tiki_Monkey 2 1.0");
        String bet = reader.readLine();
        Instant start = Instant.now();
        while (bet != null) {
          if (Duration.between(start, Instant.now()).getSeconds() >= 30) {
        	  start = Instant.now();
        	  int result = new Random().nextInt(36 - 0 + 1) + 0;
        	  System.out.println(String.format("NUMBER: %d", result));
        	  System.out.println("Player     Bet      Outcome     Winnings");
        	  System.out.println("%s     %d      %s     %d");
          }
        }
      } else {
        System.err.print(
            String.format(
                "Path: %s, is malformed, does not exist or unreadable, please check and reload.",
                pathFile.getAbsoluteFile().toString()));
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
