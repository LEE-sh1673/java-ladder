package ladder;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NaturalNumberTest {

    @Test
    void testCreateWhenOverZero() {
        assertThatCode(() -> NaturalNumber.of(1))
            .doesNotThrowAnyException();
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0})
    void testCreateWhenUnderZero(final int number) {
        assertThatThrownBy(() -> NaturalNumber.of(number))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void testToArrayIndex() {
        NaturalNumber naturalNumber = NaturalNumber.of(3);
        assertThat(naturalNumber.toArrayIndex()).isEqualTo(2);
    }
}