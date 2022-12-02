package pl.diakowski.SecondDay;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
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
                                case "X" ->  // kamień
                                        points = points + 1 + 3;
                                case "Y" ->  // papier
                                        points = points + 2 + 6;
                                case "Z" ->  // nożyce
                                        points = points + 3; // + 0
                            }
                            break;
                        case "B":  // papier
                            switch (values[1]) {
                                case "X" ->  // kamień
                                        points += 1;
                                case "Y" ->  // papier
                                        points = points + 3 + 2;
                                case "Z" ->  // nożyce
                                        points = points + 3 + 6;
                            }
                            break;
                        case "C": // nożyce
                            switch (values[1]) {
                                case "X" -> // kamień
                                    points = points + 6 + 1;
                                case "Y" -> // papier
                                    points += 2;
                                case "Z" -> // nożyce
                                    points = points + 3 + 3;
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
