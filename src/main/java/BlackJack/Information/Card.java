package BlackJack.Information;

public class Card {
    private final String card;

    public Card(String card) {
        this.card = card;
    }

    public int getValue() {
        char firstChar = card.charAt(0);
        if (firstChar == 'A') return 11;
        else if (firstChar == 'K' || firstChar == 'Q' || firstChar == 'J') return 10;
        else return firstChar - '0';
    }

//    public String getCard() {
//        return this.card;
//    }

    public static int getValue(String s) {
        char firstChar = s.charAt(0);
        if (firstChar == 'A') return 11;
        else if (firstChar == 'K' || firstChar == 'Q' || firstChar == 'J') return 10;
        else return firstChar - '0';

    }
}
