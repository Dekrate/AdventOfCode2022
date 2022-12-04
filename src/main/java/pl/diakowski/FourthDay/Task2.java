package pl.diakowski.FourthDay;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        File file = new File("src/main/java/pl/diakowski/FourthDay/data.txt");
        ArrayList<Pair> pairArrayList = new ArrayList<Pair>();
        try (Scanner scanner = new Scanner(file)) {
            long size = Files.lines(file.toPath()).count();
            for (long i = 0; i < size; i++) {
                String[] split = scanner.nextLine().split(",");
                Pair pair = new Pair();
                for (String s : split) {
                    String[] range = s.split("-");
                    pair.add(new Elf(Integer.parseInt(range[0]), Integer.parseInt(range[1])));
                }
                pairArrayList.add(pair);
            }
            int count = 0;
            for (Pair pair : pairArrayList) {
                if (pair.checkComplement()) {
                    count++;
                }
            }
            for (Pair pair : pairArrayList) {
                if (pair.checkIfOneContainAnother()) {
                    //count++;
                }
            }
            System.out.println(count);
            Pair pair = new Pair(new ArrayList<Elf>() {{
                add(new Elf(1, 3));
                add(new Elf(3, 6));
            }});
            System.out.println(pair.checkIfOneContainAnother());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
