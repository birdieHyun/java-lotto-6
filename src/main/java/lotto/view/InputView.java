package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Purchase;
import lotto.domain.WinningNumbers;

public class InputView {

    public Purchase inputPurchase() {

        return new Purchase(Console.readLine());
    }

    public WinningNumbers inputWinningNumbers() {

        return new WinningNumbers(Console.readLine());
    }
}
