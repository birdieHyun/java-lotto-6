package lotto.domain;

public class Purchase {

    private final int money;

    public Purchase(String money) {

        this.money = Integer.parseInt(money);
    }
}
