package ladder;

public class Ladder {

    private final Row[] rows;

    public Ladder(
        final int numberOfRow,
        final int numberOfPeople
    ) {
        this.rows = mapRows(numberOfRow, numberOfPeople);
    }

    private Row[] mapRows(
        final int numberOfRow,
        final int numberOfPeople
    ) {
        final Row[] rows = new Row[numberOfRow];

        for (int i = 0; i < numberOfRow; i++) {
            rows[i] = new Row(numberOfPeople);
        }
        return rows;
    }

    public void drawLine(final int numberOfRow, final int startPosition) {
        rows[numberOfRow].draw(startPosition);
    }

    public int climb(int numberOfPerson) {
        for (final Row row : rows) {
            numberOfPerson = row.climb(numberOfPerson);
        }
        return numberOfPerson;
    }
}
