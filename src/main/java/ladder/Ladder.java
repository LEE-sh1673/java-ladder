package ladder;

public class Ladder {

    private final int[] row;

    public Ladder(final int numberOfPerson) {
        this.row = new int[numberOfPerson];
    }

    void drawLine(final int startPosition) {
        row[startPosition] = 1;
        row[startPosition + 1] = 1;
    }

    public int climb(final int numberOfPerson) {

        if (numberOfPerson - 1 <= 0 && row[numberOfPerson - 1] == 1) {
            return numberOfPerson + 1;
        }

        if (row[numberOfPerson - 1] == 1) {
            if (row[numberOfPerson - 2] == 1) {
                return numberOfPerson - 1;
            }
            if (row[numberOfPerson] == 1) {
                return numberOfPerson + 1;
            }
        }
        return numberOfPerson;
    }
}
