package lotto.domain;

public class Purchase {

    private static final int LOTTO_MONEY_UNIT = 1_000;
    private final int money;

    public Purchase(String money) {

        this.money = Integer.parseInt(money);
    }

    public int getLottosCount() {

        return money / LOTTO_MONEY_UNIT;
    }
}
