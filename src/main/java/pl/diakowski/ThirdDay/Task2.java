package pl.diakowski.ThirdDay;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        File file = new File("src/main/java/pl/diakowski/ThirdDay/data.txt");
        ArrayList<Integer> wages = new ArrayList<>();
        ArrayList<Integer> groupWages = new ArrayList<>();
        try (Scanner scanner = new Scanner(file)) {
            long count = Files.lines(file.toPath()).count();
            System.out.println(count);
            for (long i = 0; i < count; i = i + 3) {
                Group group = new Group();
                group.addItems(scanner.nextLine(), 0);
                group.addItems(scanner.nextLine(), 1);
                group.addItems(scanner.nextLine(), 2);
                groupWages.add(Math.abs(group.calculateGroupWage()));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(groupWages.stream().mapToInt(Integer::intValue).sum());
    }
}
