package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Lotto;
import lotto.domain.Purchase;
import lotto.domain.SingleLottoNumber;
import lotto.validator.LottoValidator;

import java.util.Arrays;

public class InputView {

    private static final String DELIMITER = ",";

    public Purchase inputPurchase() {

        return new Purchase(Console.readLine());
    }

    public Lotto inputWinningNumbers() {

        String[] numbers = Console.readLine().split(DELIMITER);
        LottoValidator.isValidLottoNumber(numbers);

        return new Lotto(Arrays.stream(numbers)
                .map(Integer::parseInt)
                .toList());
    }

    public SingleLottoNumber inputBonusNumber() {

        return new SingleLottoNumber(Console.readLine());
    }
}
