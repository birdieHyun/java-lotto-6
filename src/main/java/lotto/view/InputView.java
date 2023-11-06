package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Purchase;

public class InputView {

    public Purchase inputPurchase() {

        return new Purchase(Console.readLine());
    }
}
