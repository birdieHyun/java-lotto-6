package lotto.domain;

import java.util.Objects;

public class SingleLottoNumber {

    private static final String ERROR_MESSAGE = "[ERROR] 로또 번호는 1~45 사이의 숫자여야 합니다.";
    private static final int MIN_RANGE = 0;
    private static final int MAX_RANGE = 45;
    private final int value;

    public SingleLottoNumber(int value) {
        if (value < MIN_RANGE || value > MAX_RANGE) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
        this.value = value;
    }

    public SingleLottoNumber(String value) {

        this.value = Integer.parseInt(value);
    }

    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SingleLottoNumber that = (SingleLottoNumber) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
