package lotto.controller;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.Map;

public class LottoController {

    private final InputView inputView;
    private final OutputView outputView;
    private final NumberGenerator numberGenerator;
    private final LottoResultCalculator lottoResultCalculator;

    public LottoController(InputView inputView, OutputView outputView, NumberGenerator numberGenerator, LottoResultCalculator lottoResultCalculator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.numberGenerator = numberGenerator;
        this.lottoResultCalculator = lottoResultCalculator;
    }

    public void startGame() {

        int lottoCount = getLottoCount();

        Lottos lottos = generateLottos(lottoCount);

        outputView.printWinningNumberMessage();
        Lotto winningNumbers = inputView.inputWinningNumbers();

        outputView.printBonusNumberMessage();
        SingleLottoNumber bonusNumber = inputView.inputBonusNumber();

        Map<String, Integer> stringIntegerMap = lottoResultCalculator.calculateResults(lottos.getLottos(), winningNumbers, bonusNumber);
        double profit = lottoResultCalculator.calculateProfit(stringIntegerMap, lottoCount * 1000);

        outputView.printResultStatistics(stringIntegerMap, profit);
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
