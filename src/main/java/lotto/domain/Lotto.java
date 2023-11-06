package lotto.domain;

import java.util.HashSet;
import java.util.List;

public class Lotto {

    private static final String LOTTO_LENGTH_ERROR_MESSAGE = "[ERROR] 로또 번호는 6개여야 합니다.";
    private static final String DUPLICATED_NUMBER_ERROR = "[ERROR] 로또 번호는 중복될 수 없습니다.";
    private static final int LOTTO_LENGTH = 6;
    private final List<SingleLottoNumber> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);

        this.numbers = numbers.stream()
                .map(SingleLottoNumber::new)
                .toList();
    }

    private void validate(List<Integer> numbers) {
        validateLottoLength(numbers);

        validateDuplicatedLotto(numbers);
    }

    private void validateDuplicatedLotto(List<Integer> numbers) {
        if (new HashSet<>(numbers).size() != numbers.size()) {
            throw new IllegalArgumentException(DUPLICATED_NUMBER_ERROR);
        }
    }

    private void validateLottoLength(List<Integer> numbers) {
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
