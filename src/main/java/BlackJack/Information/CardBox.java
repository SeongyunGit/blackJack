package BlackJack.Information;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class CardBox {
    private ArrayList<ArrayList<String>> cardBox;
    private ArrayList<String> list;
    
    public CardBox() {
        this.cardBox = new ArrayList<>();
        this.list = new ArrayList<>();
    }
    

    public void getList(int size) {
        for (int i=0; i<size; i++) {
            cardBox.add(list);
        }
    }
    public void getRandomNumber(int j, String card) {
        if (j>=0 && j<cardBox.size()) {
            cardBox.get(j).add(card);
        }
    }

    public String get(int i) {
        if (i >= 0 && i < cardBox.size()) {
            return cardBox.get(i).stream().collect(Collectors.joining(","));
        }
        else {
            throw new IndexOutOfBoundsException("Invalid i index");
        }
    }
}
