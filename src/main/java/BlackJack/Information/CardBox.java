package BlackJack.Information;

import java.util.ArrayList;
import java.util.List;

public class CardBox {
    private List<Card> cards;
    public ArrayList<String> list = new ArrayList<>();

    public CardBox() {

    }


    public int calculateNumber(int i,String[][] cardBox) {
        int total=0;
        for (String j : cardBox[i]) {
            if (j==null) {
                break;
            } else {
                total += j.indexOf(0)-'0';
            }
        }
        return total;

    }
}

