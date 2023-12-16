package ladder;

class NaturalNumber {

    private static final int MIN_NUMBER = 1;
    private static final int INTERVAL = 1;

    private final int number;

    private NaturalNumber(final int number) {
        validate(number);
        this.number = number;
    }

    private void validate(final int number) {
        if (number < MIN_NUMBER) {
            throw new IllegalArgumentException("자연수는 1이상인 숫자여야 합니다.");
        }
    }

    static NaturalNumber of(final int number) {
        return new NaturalNumber(number);
    }

    int getNumber() {
        return number;
    }

    int toArrayIndex() {
        return number - INTERVAL;
    }
}
