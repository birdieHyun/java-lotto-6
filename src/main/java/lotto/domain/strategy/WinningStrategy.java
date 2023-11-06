package lotto.domain.strategy;

import lotto.domain.Lotto;
import lotto.domain.SingleLottoNumber;

public interface WinningStrategy {
    boolean matches(Lotto lotto, Lotto winningNumbers, SingleLottoNumber bonusNumber);
    String getResultKey();
    int getWinningMoney();
}
