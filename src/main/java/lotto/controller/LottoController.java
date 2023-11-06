package lotto.controller;

import lotto.domain.*;
import lotto.validator.LottoValidator;
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

        Lotto winningNumbers = getWinningLotto();
        SingleLottoNumber bonusNumber = getBonusNumber(winningNumbers);

        Map<String, Integer> stringIntegerMap = lottoResultCalculator.calculateResults(lottos.getLottos(), winningNumbers, bonusNumber);
        double profit = lottoResultCalculator.calculateProfit(stringIntegerMap, lottoCount * 1000);

        outputView.printResultStatistics(stringIntegerMap, profit);
    }

    private SingleLottoNumber getBonusNumber(Lotto winningNumbers) {

        boolean isValid = false;
        SingleLottoNumber bonusNumber = null;

        while (!isValid) {
            try {
                outputView.printBonusNumberMessage();
                bonusNumber = inputView.inputBonusNumber();
                LottoValidator.isValidBonusNumber(winningNumbers, bonusNumber);
                isValid = true;
            } catch (IllegalArgumentException e) {
                outputView.printError(e.getMessage());
            }
        }
        return bonusNumber;
    }

    private Lotto getWinningLotto() {
        Lotto winningNumbers = null;
        boolean isValid = false;

        while (!isValid) {
            try {
                outputView.printWinningNumberMessage();
                winningNumbers = inputView.inputWinningNumbers();
                isValid = true;
            } catch (IllegalArgumentException e) {
                outputView.printError(e.getMessage());
            }

        }
        return winningNumbers;
    }

    private Lottos generateLottos(int lottoCount) {
        Lottos lottos = Lottos.generate(lottoCount, numberGenerator);
        outputView.printPurchasedLotto(lottoCount, lottos);

        return lottos;
    }

    private int getLottoCount() {

        boolean isValid = false;
        Purchase purchase = null;

        while (!isValid) {
            try {
                outputView.printPurchaseMessage();
                purchase = inputView.inputPurchase();
                isValid = true;
            } catch (IllegalArgumentException e) {
                outputView.printError(e.getMessage());
            }
        }

        return purchase.getLottosCount();
    }

}
