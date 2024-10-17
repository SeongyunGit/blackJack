package BlackJack.Information;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class CardBox {
    public static ArrayList<String> list=new ArrayList<>();
    private List<Card> cards;

//    public CardBox() {
//        this.list = new ArrayList<>();
//    }


    public static void getList(ArrayList<ArrayList<String>> cardBox,int size) {
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

