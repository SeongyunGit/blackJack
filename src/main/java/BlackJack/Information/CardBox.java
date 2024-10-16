package BlackJack.Information;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class CardBox {
    private ArrayList<ArrayList<String>> cardBox;
    private ArrayList<String> list;
    private List<Card> cards;

    public CardBox() {
        this.cardBox = new ArrayList<>();
        this.list = new ArrayList<>();

    }


    public void getList(int size) {
        for (int i = 0; i < size; i++) {
            cardBox.add(list);
        }
    }

    public void getRandomNumber(String card,int j) {
        if (j >= 0 && j < cardBox.size()) {
            cardBox.get(j).add(card);
        }
    }

    public String get(int i) {
        if (i >= 0 && i < cardBox.size()) {
            return cardBox.get(i).stream().collect(Collectors.joining(","));
        } else {
            throw new IndexOutOfBoundsException("Invalid i index");
        }
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

