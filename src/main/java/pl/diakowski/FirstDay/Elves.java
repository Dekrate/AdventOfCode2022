package pl.diakowski.FirstDay;

import java.util.*;

public class Elves {
    private ArrayList<Elf> elves = new ArrayList<>();

    public Elves() {
    }

    public ArrayList<Elf> getElves() {
        return elves;
    }

    public void setElves(ArrayList<Elf> elves) {
        this.elves = elves;
    }

    public void addToList(Elf elf) {
        elves.add(elf);
    }

    public int maxValue() {
        ArrayList<Integer> maxValues = new ArrayList<>();
        elves.forEach(elf -> {
            maxValues.add(elf.getCalories().stream()
                    .mapToInt(Integer::intValue)
                    .sum());
        });
        maxValues.sort(Integer::compareTo);
        return maxValues.get(maxValues.size() - 1);
    }

    public int sumOfTopThreeElves() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        elves.forEach(elf -> {
            arrayList.add(elf.getCalories().stream().mapToInt(Integer::intValue).sum());
        });
        Collections.sort(arrayList);
        return arrayList.get(arrayList.size() - 1) + arrayList.get(arrayList.size() - 2)
                + arrayList.get(arrayList.size() - 3);
    }
}
