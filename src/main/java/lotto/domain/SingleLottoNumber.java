package lotto.domain;

import java.util.Objects;

public class SingleLottoNumber {

    private final int value;

    public SingleLottoNumber(int value) {

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
