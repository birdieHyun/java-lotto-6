package lotto.domain;

public class WinningNumber {

    private final int value;

    // TODO: 1~45 사이의 숫자인지 검증하기
    public WinningNumber(String value) {
        this.value = Integer.parseInt(value);
    }
}
