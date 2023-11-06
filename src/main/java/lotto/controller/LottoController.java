package lotto.controller;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

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

        int lottoCount = getLottoCount();

        Lottos lottos = generateLottos(lottoCount);

        outputView.printWinningNumberMessage();
        Lotto winningNumbers = inputView.inputWinningNumbers();

        outputView.printBonusNumberMessage();
        SingleLottoNumber bonusNumber = inputView.inputBonusNumber();

    }

    private Lottos generateLottos(int lottoCount) {
        Lottos lottos = Lottos.generate(lottoCount, numberGenerator);
        outputView.printPurchasedLotto(lottoCount, lottos);

        return lottos;
    }

    private int getLottoCount() {
        outputView.printPurchaseMessage();
        Purchase purchase = inputView.inputPurchase();
        int lottoCount = purchase.getLottosCount();
        return lottoCount;
    }
}
