package lotto;

import lotto.controller.LottoController;
import lotto.domain.LottoResultCalculator;
import lotto.domain.RandomNumberGenerator;
import lotto.domain.strategy.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class Application {
    public static void main(String[] args) {

        LottoController lottoController = new LottoController(
                new InputView(),
                new OutputView(),
                new RandomNumberGenerator(),
                new LottoResultCalculator(
                        List.of(
                                new ThreeMatchStrategy(),
                                new FourMatchStrategy(),
                                new FiveMatchStrategy(),
                                new FiveAndBonusMatchStrategy(),
                                new SixMatchStrategy()
                        )
                )
        );

        lottoController.startGame();
    }
}
