package lotto.view;

import lotto.domain.Lottos;

import java.util.Map;
import java.util.stream.Collectors;

public class OutputView {

    private static final String PURCHASE_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String PURCHASED_LOTTO = "개를 구매했습니다.";
    private static final String WINNING_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";
    private static final String RESULT_MESSAGE = "당첨 통계";
    private static final String SEPARATOR = "---";
    private static final String THREE_MATCH = "3개 일치 (5,000원) - ";
    private static final String FOUR_MATCH = "4개 일치 (50,000원) - ";
    private static final String FIVE_MATCH = "5개 일치 (1,500,000원) - ";
    private static final String FIVE_MATCH_WITH_BONUS = "5개 일치, 보너스 볼 일치 (30,000,000원) - ";
    private static final String SIX_MATCH = "6개 일치 (2,000,000,000원) - ";
    private static final String COUNT = "개";
    private static final String PROFIT_RATE = "총 수익률은 ";
    private static final String PERCENT = "%입니다.";
    private static final String DELIMITER = ", ";
    private static final String PREFIX = "[";
    private static final String SUFFIX = "]";

    public void printPurchaseMessage() {

        System.out.println(PURCHASE_MESSAGE);
    }

    public void printPurchasedLotto(int lottoCount, Lottos lottos) {
        StringBuilder purchasedLotto = new StringBuilder();

        purchasedLotto.append(lottoCount)
                .append(PURCHASED_LOTTO)
                .append(System.lineSeparator());

        String result = lottos.getLottos().stream()
                .map(lotto -> lotto.getNumbers().stream()
                        .map(singleLottoNumber -> String.valueOf(singleLottoNumber.getValue()))
                        .collect(Collectors.joining(DELIMITER, PREFIX, SUFFIX)))
                .collect(Collectors.joining(System.lineSeparator()));

        purchasedLotto.append(result).append(System.lineSeparator());

        System.out.println(purchasedLotto);
    }

    public void printWinningNumberMessage() {

        System.out.println(WINNING_NUMBER_MESSAGE);
    }

    public void printBonusNumberMessage() {

        System.out.println(BONUS_NUMBER_MESSAGE);
    }

    public void printResultStatistics(Map<String, Integer> results, double profitRate) {

        StringBuilder statistics = new StringBuilder();

        statistics.append(RESULT_MESSAGE).append(System.lineSeparator())
                .append(SEPARATOR).append(System.lineSeparator())
                .append(THREE_MATCH).append(results.get("threeMatch")).append(COUNT).append(System.lineSeparator())
                .append(FOUR_MATCH).append(results.get("fourMatch")).append(COUNT).append(System.lineSeparator())
                .append(FIVE_MATCH).append(results.get("fiveMatch")).append(COUNT).append(System.lineSeparator())
                .append(FIVE_MATCH_WITH_BONUS).append(results.get("fiveMatchWithBonus")).append(COUNT).append(System.lineSeparator())
                .append(SIX_MATCH).append(results.get("sixMatch")).append(COUNT).append(System.lineSeparator())
                .append(PROFIT_RATE).append(profitRate).append(PERCENT);

        System.out.println(statistics);
    }

    public void printError(String message) {

        System.out.println(message);
    }
}
