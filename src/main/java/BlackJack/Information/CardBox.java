package BlackJack.Information;

import java.util.ArrayList;
import java.util.List;

public class CardBox {
    private List<Card> cards;
    public ArrayList<String> list = new ArrayList<>();

    public CardBox(ArrayList<String> list) {
        this.list = list;
    }


    public void getList(ArrayList<ArrayList<String>> cardBox, int size) {
        for (int i = 0; i < size; i++) {
            cardBox.add(list);
        }
    }


    public int calculateNumber(int i,ArrayList<ArrayList<String>> cardBox) {
        int total=0;
        for (String j : cardBox.get(i)) {
            total += j.indexOf(0);
        }
        return total;

    }
}

