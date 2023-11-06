package lotto.controller;

import lotto.domain.*;
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

        Lotto winningNumbers = inputView.inputWinningNumbers();

        outputView.printBonusNumberMessage();

        int bonusNumber = inputView.inputBonusNumber();


    }
}
