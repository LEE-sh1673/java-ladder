package ladder;

public class Ladder {

    private final int[][] rows;

    public Ladder(
        final int countOfRow,
        final int numberOfPerson
    ) {
        this.rows = new int[countOfRow][numberOfPerson];
    }

    public void drawLine(final int numberOfRow, final int startPosition) {
        rows[numberOfRow][startPosition] = 1;
        rows[numberOfRow][startPosition + 1] = 1;
    }

    public int climb(int numberOfPerson) {
        for (final int[] row : rows) {
            numberOfPerson = climbRow(numberOfPerson, row);
        }
        return numberOfPerson;
    }

    private int climbRow(int numberOfPerson, int[] row) {
        if (row[numberOfPerson] == 0) {
            return numberOfPerson;
        }
        if (numberOfPerson - 1 >= 0 && row[numberOfPerson - 1] == 1) {
            return numberOfPerson - 1;
        }
        return numberOfPerson + 1;
    }
}
