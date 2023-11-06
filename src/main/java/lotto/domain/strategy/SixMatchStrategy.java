package lotto.domain.strategy;

import lotto.domain.Lotto;
import lotto.domain.SingleLottoNumber;

public class SixMatchStrategy implements WinningStrategy{

    private static final int SIX_MATCH = 6;
    private static final String STRATEGY_NAME = "sixMatch";
    private static final int WINNING_MONEY = 2_000_000_000;

    @Override
    public boolean matches(Lotto lotto, Lotto winningNumbers, SingleLottoNumber bonusNumber) {
        return lotto.getMatchCount(winningNumbers) == SIX_MATCH;
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
