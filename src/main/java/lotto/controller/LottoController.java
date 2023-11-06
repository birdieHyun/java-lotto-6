package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.NumberGenerator;
import lotto.domain.Purchase;
import lotto.domain.WinningNumbers;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class LottoController {

    private final InputView inputView;
    private final OutputView outputView;
    private final NumberGenerator numberGenerator;

    public LottoController(InputView inputView, OutputView outputView, NumberGenerator numberGenerator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.numberGenerator = numberGenerator;
    }

    public void startGame() {
        List<Lotto> lottos = new ArrayList<>();
        outputView.printPurchaseMessage();
        Purchase purchase = inputView.inputPurchase();
        int lottoCount = purchase.getLottosCount();
        for (int i = 0; i < lottoCount; i++) {

            lottos.add(new Lotto(numberGenerator.generate()));
        }

        outputView.printPurchasedLotto(lottoCount, lottos);

        outputView.printWinningNumberMessage();

        WinningNumbers winningNumbers = inputView.inputWinningNumbers();
    }
}
