package lotto.domain;

import java.util.List;

public class Lotto {

    private static final String LOTTO_LENGTH_ERROR_MESSAGE = "[ERROR] 로또 번호는 6개여야 합니다.";
    private static final int LOTTO_LENGTH = 6;
    private final List<SingleLottoNumber> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);

        this.numbers = numbers.stream()
                .map(SingleLottoNumber::new)
                .toList();
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_LENGTH) {
            throw new IllegalArgumentException(LOTTO_LENGTH_ERROR_MESSAGE);
        }
    }

    public long getMatchCount(Lotto winningNumbers) {
        return numbers.stream()
                .filter(winningNumbers.getNumbers()::contains)
                .count();
    }

    public boolean matchBonusNumber(SingleLottoNumber bonusNumber) {
        return numbers.contains(bonusNumber);
    }


    public List<SingleLottoNumber> getNumbers() {

        return numbers;
    }
}
