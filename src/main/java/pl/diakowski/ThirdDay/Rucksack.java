package pl.diakowski.ThirdDay;

public class Rucksack {
    private final String[] items = new String[2];

    public Rucksack() {
    }

    public void findAndAddItemsToRucksack(String line) {
        int length = line.length() / 2;
        String[] items = {line.substring(0, length), line.substring(length)};
        this.items[0] = items[0];
        this.items[1] = items[1];
    }

    public Character findTheSameChar() throws NoSuchFieldException {
        char[] firstItemChars = items[0].toCharArray();
        char[] secondItemChars = items[1].toCharArray();
        for (char firstItemChar : firstItemChars) {
            for (char secondItemChar : secondItemChars) {
                if (firstItemChar == secondItemChar) {
                    return firstItemChar;
                }
            }
        }
        throw new NoSuchFieldException("Element not found."); // never used
    }
}
