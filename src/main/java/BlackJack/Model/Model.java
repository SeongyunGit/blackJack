package BlackJack.Model;

import java.util.List;

public class Model {


    public String[][] randomPick(List<String> nameList) {
        String[][] cardBox = new String[nameList.size()][10];

        for (int i=0;i< nameList.size();i++) {
            for (int j=0;j<2;j++) {
                CardDeck cardDeck = new CardDeck();
                cardBox[i][j] = cardDeck.distribute().getCardNumber().getSymbol() + cardDeck.distribute().getCardType().getType();

            }
        }
        return cardBox;
    }

    public static void dealerPickCard(int i,String[][] cardBox,int j) {
        CardDeck cardDeck = new CardDeck();
        cardBox[i][j] = cardDeck.distribute().getCardNumber().getSymbol() + cardDeck.distribute().getCardType().getType();

    }
}