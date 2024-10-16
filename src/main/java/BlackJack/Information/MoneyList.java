package BlackJack.Information;

import java.util.ArrayList;
import java.util.List;

public class MoneyList {
    private final List<Integer> moneyList;

    public MoneyList() {
        this.moneyList = new ArrayList<>();
    }

    public List<Integer> getMoneyList() {
        return this.moneyList;
    }

    public void dealerMoney() {
        this.moneyList.add(0,0);
    }

    public void addMoney(int money) {
        this.moneyList.add(money);
    }

}
