package pl.diakowski.ThirdDay;

import java.util.NoSuchElementException;

public class Group {
    private String[] items = new String[3];

    public Group() {
    }

    public Group(String[] items) {
        this.items = items;
    }

    public void addItems(String line, int index) {
        items[index] = line;
    }

    private Character findTheSameLetter() {
        char[] firstElfRucksack = items[0].toCharArray();
        char[] secondElfRucksack = items[1].toCharArray();
        char[] thirdElfRucksack = items[2].toCharArray();
        for (char c : firstElfRucksack) {
            for (char c1 : secondElfRucksack) {
                for (char c2 : thirdElfRucksack) {
                    if (c == c1 && c1 == c2) {
                        return c;
                    }
                }
            }
        }
        throw new NoSuchElementException("Element not found"); // never used
    }

    public int calculateGroupWage() {
        Character theSameLetter = findTheSameLetter();
            if (Character.isLowerCase(theSameLetter)) {
                return 96 - (int) theSameLetter;
            } else {
                return 38 - (int) theSameLetter;
            }
    }
}
