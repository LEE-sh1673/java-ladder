package ladder;

class Ladder {

    private final Row[] rows;

    Ladder(final NaturalNumber height, final NaturalNumber numberOfPerson) {
        this.rows = new Row[height.getNumber()];

        for (int i = 0; i < height.getNumber(); i++) {
            rows[i] = new Row(numberOfPerson);
        }
    }

    void drawLine(final NaturalNumber height, final NaturalNumber startPosition) {
        if (height.toArrayIndex() >= rows.length) {
            throw new IllegalArgumentException("유효하지 않은 높이입니다.");
        }
        rows[height.toArrayIndex()].drawLine(startPosition);
    }

    int move(final NaturalNumber numberOfPerson) {
        int dest = numberOfPerson.getNumber();
        for (final Row row : rows) {
            dest = row.move(NaturalNumber.of(dest));
        }
        return dest;
    }

    String map() {
        final StringBuilder sb = new StringBuilder();

        for (final Row row : rows) {
            sb.append(row.map());
            sb.append(System.lineSeparator());
        }
        return sb.toString();
    }
}
