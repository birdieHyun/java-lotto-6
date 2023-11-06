package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Lotto;
import lotto.domain.Purchase;
import lotto.domain.SingleLottoNumber;

import java.util.Arrays;

public class InputView {

    private static final String DELIMITER = ",";

    public Purchase inputPurchase() {

        return new Purchase(Console.readLine());
    }

    public Lotto inputWinningNumbers() {

        String[] numbers = Console.readLine().split(DELIMITER);
        // TODO : numbers 검증
        return new Lotto(Arrays.stream(numbers)
                .map(String::trim)
                .map(Integer::parseInt)
                .toList());
    }

    public SingleLottoNumber inputBonusNumber() {

        return new SingleLottoNumber(Console.readLine());
    }
}
