package pl.diakowski.SecondDay;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        int points = 0;
        File file = new File("src/main/java/pl/diakowski/SecondDay/data.txt");
        try (Scanner scanner = new Scanner(file)) {
            long count = Files.lines(file.toPath()).count();
            ArrayList<Integer> possiblePoints = new ArrayList<>();
            for (long i = 0; i < count + 1; i++) {
                if (scanner.hasNextLine()) {
                    String s = scanner.nextLine();
                    // GRACZ: X kamień, Y papier, Z nożyczki
                    // OPONENT: niech A - kamień, B - kamień, C - nożyczki
                    String[] values = s.split(" ");
                    switch (values[0]) {
                        case "A":  // kamień
                            switch (values[1]) {
                                case "X" ->  // porażka -> nożyczki
                                        points = points + 3;
                                case "Y" ->  // remis -> kamień
                                        points = points + 3 + 1;
                                case "Z" ->  // zwycięstwo -> papier
                                        points = points + 2 + 6;
                            }
                            break;
                        case "B":  // papier
                            switch (values[1]) {
                                case "X" ->  // porażka -> kamień
                                        points += 1;
                                case "Y" ->  // remis -> papier
                                        points = points + 3 + 2;
                                case "Z" ->  // nożyce
                                        points = points + 3 + 6;
                            }
                            break;
                        case "C": // nożyce
                            switch (values[1]) {
                                case "X" -> // porażka -> papier
                                        points = points + 2;
                                case "Y" -> // remis -> nożyce
                                        points = points + 3 + 3;
                                case "Z" -> // zwycięstwo -> kamień
                                        points = points + 1 + 6;
                            }
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(points);
    }
}
