package lotto.domain;

import java.util.Arrays;
import java.util.List;

public class WinningNumbers {

    private final List<WinningNumber> value;

    public WinningNumbers(String input) {

        // TODO: 6자리 입력인지 검증하기
        String[] splited = input.split(",");

        // TODO: 중복되는지 검증하기
        this.value = Arrays.stream(splited)
                .map(WinningNumber::new)
                .toList();
    }
}
