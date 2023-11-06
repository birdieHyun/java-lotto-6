package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Lotto;
import lotto.domain.Purchase;

import java.util.Arrays;
import java.util.List;

public class InputView {

    private static final String DELIMITER = ",";

    public Purchase inputPurchase() {

        return new Purchase(Console.readLine());
    }

    public Lotto inputWinningNumbers() {

        List<Integer> numbers = Arrays.stream(Console.readLine().split(DELIMITER))
                .map(String::trim)
                .map(Integer::parseInt)
                .toList();

        return new Lotto(numbers);
    }

    public int inputBonusNumber() {

        return Integer.parseInt(Console.readLine());
    }
}
