package BlackJack.Information;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class CardBox {
    private ArrayList<String> list;
    private List<Card> cards;

    public CardBox() {
        this.list = new ArrayList<>();
    }


    public void getList(ArrayList<ArrayList<String>> cardBox,int size) {
        for (int i = 0; i < size; i++) {
            cardBox.add(list);
        }
    }

    public void getRandomNumber(ArrayList<ArrayList<String>> cardBox,String card,int k) {
            cardBox.get(k).add(card);
    }

    public void get(int i,String card) {
        cardBox.get(i).add(card);
    }

    public int calculateNumber() {
        return cards.stream()
                .mapToInt(Card::getValue)
                .sum();
    }
    public ArrayList<String> getPlayerCards(int playerIndex) {
        return cardBox.get(playerIndex);
    }

    public int calculatePlayerScore(int playerIndex) {
        return getPlayerCards(playerIndex).stream()
                .mapToInt(Card::getValue)
                .sum();
    }


    public ArrayList<ArrayList<String>> getAllPlayerCards() {
        return cardBox;
    }

}

