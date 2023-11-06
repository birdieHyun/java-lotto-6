package lotto.validator;

import java.util.Arrays;

public class LottoValidator {

    private static final String ERROR_MESSAGE = "[ERROR] 로또 번호는 숫자여야 합니다.";

    public static void isValidLottoNumber(String[] numbers) {

        Arrays.stream(numbers)
                .forEach(LottoValidator::isValidNumber);
    }

    private static void isValidNumber(String number) {
        try {
            Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
    }
}
