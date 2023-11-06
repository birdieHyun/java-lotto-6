package lotto.domain;

import lotto.domain.strategy.WinningStrategy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoResultCalculator {

    private static final int DEFAULT_VALUE = 0;
    private static final double RATIO = 100.0;
    private final List<WinningStrategy> strategies;

    public LottoResultCalculator(List<WinningStrategy> strategies) {
        this.strategies = strategies;
    }

    public Map<String, Integer> calculateResults(List<Lotto> lottos, Lotto winningNumbers, SingleLottoNumber bonusNumber) {
        Map<String, Integer> results = new HashMap<>();
        for (WinningStrategy strategy : strategies) {
            results.put(strategy.getResultKey(), 0);
        }

        for (Lotto lotto : lottos) {
            for (WinningStrategy strategy : strategies) {
                if (strategy.matches(lotto, winningNumbers, bonusNumber)) {
                    results.put(strategy.getResultKey(), results.get(strategy.getResultKey()) + 1);
                }
            }
        }
        return results;
    }

    public double calculateProfit(Map<String, Integer> results, int money) {

        double profit = strategies.stream()
                .mapToDouble(strategy -> results.getOrDefault(strategy.getResultKey(), DEFAULT_VALUE) * strategy.getWinningMoney())
                .sum();

        double profitRate = (profit / money) * RATIO;

        profitRate = Math.round(profitRate * RATIO) / RATIO;

        return profitRate;
    }
}