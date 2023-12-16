package ladder;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LadderTest {

    @ParameterizedTest
    @ValueSource(ints = {0, 4})
    void testDrawLineWhenInvalidHeight(final int height) {
        Ladder ladder = new Ladder(NaturalNumber.of(3), NaturalNumber.of(4));
        assertThatThrownBy(() -> ladder.drawLine(NaturalNumber.of(height), NaturalNumber.of(0)))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void testMoveWhenMultiRows() {
        // 1 1 0 0
        // 0 1 1 0
        // 0 0 1 1
        Ladder ladder = new Ladder(NaturalNumber.of(3), NaturalNumber.of(4));

        ladder.drawLine(NaturalNumber.of(1), NaturalNumber.of(1));
        ladder.drawLine(NaturalNumber.of(2), NaturalNumber.of(2));
        ladder.drawLine(NaturalNumber.of(3), NaturalNumber.of(3));

        assertEquals(4, ladder.move(NaturalNumber.of(1)));
        assertEquals(1, ladder.move(NaturalNumber.of(2)));
        assertEquals(2, ladder.move(NaturalNumber.of(3)));
        assertEquals(3, ladder.move(NaturalNumber.of(4)));
        System.out.println(ladder.map());

        /*
            0 1 1 0
            0 0 1 1
        */
        ladder = new Ladder(NaturalNumber.of(2), NaturalNumber.of(4));
        ladder.drawLine(NaturalNumber.of(1), NaturalNumber.of(2));
        ladder.drawLine(NaturalNumber.of(2), NaturalNumber.of(3));

        assertEquals(4, ladder.move(NaturalNumber.of(2)));
        assertEquals(2, ladder.move(NaturalNumber.of(3)));
        System.out.println(ladder.map());
    }
}
