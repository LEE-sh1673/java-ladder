package ladder;

import static ladder.Direction.CENTER;
import static ladder.Direction.LEFT;
import static ladder.Direction.RIGHT;

class Row {

    private final int[] nodes;

    Row(final NaturalNumber numberOfPerson) {
        this.nodes = new int[numberOfPerson.getNumber()];
    }

    void drawLine(final NaturalNumber startPosition) {
        final int startIndex = startPosition.toArrayIndex();

        validateLine(startIndex);
        nodes[startIndex] = RIGHT.getNumber();
        nodes[startIndex + 1] = LEFT.getNumber();
    }

    private void validateLine(final int position) {
        validateRange(position);
        validateLineDuplicates(position);
    }

    private void validateRange(int position) {
        if (position >= nodes.length - 1) {
            throw new IllegalArgumentException(
                String.format("시작점은 %d이하여야 합니다.", nodes.length - 1)
            );
        }
    }

    private void validateLineDuplicates(int position) {
        if (nodes[position] == LEFT.getNumber()) {
            throw new IllegalArgumentException("선을 그을 수 없는 위치입니다.");
        }
    }

    int move(final NaturalNumber numberOfPerson) {
        if (numberOfPerson.toArrayIndex() >= nodes.length) {
            throw new IllegalArgumentException("올바르지 않은 위치입니다.");
        }
        if (isNoLine(numberOfPerson.toArrayIndex())) {
            return numberOfPerson.getNumber();
        }
        if (isRightDirection(numberOfPerson.toArrayIndex())) {
            return numberOfPerson.getNumber() + 1;
        }
        return numberOfPerson.getNumber() - 1;
    }

    private boolean isNoLine(final int numberOfPerson) {
        return nodes[numberOfPerson] == CENTER.getNumber();
    }

    private boolean isRightDirection(final int numberOfPerson) {
        return nodes[numberOfPerson] == RIGHT.getNumber();
    }

    String map() {
        final StringBuilder sb = new StringBuilder();
        for (final int node : nodes) {
            sb.append(generateNode(node));
        }
        return sb.toString();
    }

    private String generateNode(final int node) {
        if (node == RIGHT.getNumber()) {
            return "|--";
        }
        return "|  ";
    }
}
