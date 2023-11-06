package lotto.domain;

public class Purchase {

    private static final String LOTTO_PURCHASE_UNIT_ERROR_MESSAGE = "[ERROR] 로또 구입 금액은 1000원 단위로 입력해야 합니다.";
    private static final int LOTTO_MONEY_UNIT = 1_000;
    private final int money;

    public Purchase(String money) {

        int lottoMoney = Integer.parseInt(money);

        if( lottoMoney < 1000 || lottoMoney % 1000 != 0) {
            throw new IllegalArgumentException(LOTTO_PURCHASE_UNIT_ERROR_MESSAGE);
        }

        this.money = lottoMoney;
    }

    public int getLottosCount() {

        return money / LOTTO_MONEY_UNIT;
    }
}
