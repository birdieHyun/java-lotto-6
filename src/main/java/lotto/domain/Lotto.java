package lotto.domain;

import java.util.List;

public class Lotto {
    private final List<SingleLottoNumber> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);

        this.numbers = numbers.stream()
                .map(SingleLottoNumber::new)
                .toList();
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현

    public List<SingleLottoNumber> getNumbers() {

        return numbers;
    }
}
