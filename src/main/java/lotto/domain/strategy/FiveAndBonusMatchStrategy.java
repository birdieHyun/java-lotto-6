package lotto.domain.strategy;

import lotto.domain.Lotto;
import lotto.domain.SingleLottoNumber;

public class FiveAndBonusMatchStrategy implements WinningStrategy{

    private static final int FIVE_MATCH = 5;
    private static final String STRATEGY_NAME = "fiveMatchWithBonus";
    private static final int WINNING_MONEY = 30_000_000;

    @Override
    public boolean matches(Lotto lotto, Lotto winningNumbers, SingleLottoNumber bonusNumber) {
        return lotto.getMatchCount(winningNumbers) == FIVE_MATCH && lotto.matchBonusNumber(bonusNumber);
    }

    @Override
    public String getResultKey() {
        return STRATEGY_NAME;
    }

    @Override
    public int getWinningMoney() {
        return WINNING_MONEY;
    }
}
