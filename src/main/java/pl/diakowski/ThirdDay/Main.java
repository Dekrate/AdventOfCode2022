package pl.diakowski.ThirdDay;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        File file = new File("src/main/java/pl/diakowski/ThirdDay/data.txt");
        ArrayList<Integer> wages = new ArrayList<>();
        try (Scanner scanner = new Scanner(file)) {
            long count = Files.lines(file.toPath()).count();
            System.out.println(count);
            for (long i = 0; i < count; i++) {
                String line = scanner.nextLine();
                Rucksack rucksack = new Rucksack();
                rucksack.findAndAddItemsToRucksack(line);
                Char aChar = new Char(rucksack.findTheSameChar());
                wages.add(Math.abs(aChar.calculateWage()));
            }
        } catch (IOException | NoSuchFieldException e) {
            throw new RuntimeException(e);
        }
        System.out.println(wages.stream().mapToInt(Integer::intValue).sum());
    }
}
