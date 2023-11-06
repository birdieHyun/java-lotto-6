package lotto.validator;

import lotto.domain.Lotto;
import lotto.domain.SingleLottoNumber;

import java.util.Arrays;

public class LottoValidator {

    private static final String ERROR_MESSAGE = "[ERROR] 로또 번호는 숫자여야 합니다.";
    private static final String BONUS_NUMBER_ERROR_MESSAGE = "[ERROR] 보너스 번호는 로또 번호와 중복될 수 없습니다.";

    public static void isValidLottoNumber(String[] numbers) {

        Arrays.stream(numbers)
                .forEach(LottoValidator::isValidNumber);
    }

    public static void isValidBonusNumber(Lotto lotto, SingleLottoNumber bonusNumber) {

        if (lotto.getNumbers().contains(bonusNumber)) {
            throw new IllegalArgumentException(BONUS_NUMBER_ERROR_MESSAGE);
        }
    }

    private static void isValidNumber(String number) {
        try {
            Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
    }
}
