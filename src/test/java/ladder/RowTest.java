package ladder;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

class RowTest {

    private Row row;

    @BeforeEach
    void setUp() {
        row = new Row(NaturalNumber.of(3));
    }

    @Test
    @DisplayName("선이 없는 경우 그대로 반환할 수 있다.")
    void testMoveWhenNoLine() {
        assertEquals(1, row.move(NaturalNumber.of(1)));
        assertEquals(3, row.move(NaturalNumber.of(3)));
    }

    @Test
    @DisplayName("선이 1개가 좌측으로 그어져 있는 경우")
    void testMoveWhenLineLeft() {
        // 0 1 1
        row.drawLine(NaturalNumber.of(2));
        assertEquals(2, row.move(NaturalNumber.of(3)));

        // 1 1 0
        row = new Row(NaturalNumber.of(3));
        row.drawLine(NaturalNumber.of(1));
        assertEquals(1, row.move(NaturalNumber.of(2)));
    }

    @Test
    @DisplayName("선이 1개가 우측으로 그어져 있는 경우")
    void testMoveWhenLineRight() {
        // 0 1 1
        row.drawLine(NaturalNumber.of(2));
        assertEquals(3, row.move(NaturalNumber.of(2)));

        // 1 1 0
        row = new Row(NaturalNumber.of(3));
        row.drawLine(NaturalNumber.of(1));
        assertEquals(2, row.move(NaturalNumber.of(1)));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 3})
    void testDrawLineWhenInvalidPosition(final int position) {
        assertThatThrownBy(() -> row.drawLine(NaturalNumber.of(position)))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void testDrawLineWhenLineDuplicates() {
        row.drawLine(NaturalNumber.of(1));
        assertThatThrownBy(() -> row.drawLine(NaturalNumber.of(2)))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 4})
    void testMoveWhenInvalidPosition(final int position) {
        assertThatThrownBy(() -> row.move(NaturalNumber.of(position)))
            .isInstanceOf(IllegalArgumentException.class);
    }
}