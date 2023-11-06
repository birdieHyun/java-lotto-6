package lotto.domain;

public class Purchase {

    private static final String LOTTO_PURCHASE_UNIT_ERROR_MESSAGE = "[ERROR] 로또 구입 금액은 1000원 단위의 숫자로 입력해야 합니다.";
    private static final int LOTTO_MONEY_UNIT = 1_000;
    private static final int ZERO_CHANGE = 0;
    private final int money;

    public Purchase(String money) {

        int lottoMoney = getLottoMoney(money);
        validateLottoUnit(lottoMoney);

        this.money = lottoMoney;
    }

    private static void validateLottoUnit(int lottoMoney) {

        if( lottoMoney < LOTTO_MONEY_UNIT || lottoMoney % LOTTO_MONEY_UNIT != ZERO_CHANGE) {
            throw new IllegalArgumentException(LOTTO_PURCHASE_UNIT_ERROR_MESSAGE);
        }
    }

    private static int getLottoMoney(String money) {
        int lottoMoney;
        try {
            lottoMoney = Integer.parseInt(money);
        }catch (NumberFormatException e) {
            throw new IllegalArgumentException(LOTTO_PURCHASE_UNIT_ERROR_MESSAGE);
        }
        return lottoMoney;
    }

    public int getLottosCount() {

        return money / LOTTO_MONEY_UNIT;
    }
}
