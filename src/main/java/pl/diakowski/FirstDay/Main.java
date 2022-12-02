package pl.diakowski.FirstDay;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Elves elves = new Elves();
        ArrayList<Integer> caloriesOfElf = new ArrayList<>();
            File file = new File("src/main/java/pl/diakowski/FirstDay/data.txt");
        try {
            long count = Files.lines(file.toPath()).count()+1;
            Scanner scanner = new Scanner(file);
            Elf elf = new Elf();
            for (long i = 0; i < count - 1; i++) {
                String nextLine = scanner.nextLine();
                if (!Objects.equals(nextLine, "")) {
                    Objects.requireNonNull(elf).addToList(Integer.parseInt(nextLine));
                } else {
                    elves.addToList(elf);
                    elf = new Elf();
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(elves.maxValue());
        System.out.println(elves.sumOfTopThreeElves());
    }
}
