package BlackJack.Model;

import java.util.*;

public class CardDeck {

    private static final Deque<Card> cards = new ArrayDeque<>();

    static {
        final List<Card> cardGroup = new ArrayList<>();
        for (final CardType type : CardType.values()) {
            Arrays.stream(CardNumber.values())
                    .forEach(number-> cardGroup.add(new Card(number,type)));
        }
        Collections.shuffle(cardGroup);
        cards.addAll(cardGroup);
    }

    CardDeck() {

    }

    public static Card distribute() {
        return cards.pop();
    }
}
