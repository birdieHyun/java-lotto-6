package lotto.domain;

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
}
