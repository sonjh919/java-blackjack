package blackjack.card;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CardDeckFactory {

    public CardDeck create() {
        List<Card> cards = new ArrayList<>();
        for (Suit suit : Suit.values()) {
            selectNumbers(suit, cards);
        }
        Collections.shuffle(cards);
        return new CardDeck(cards);
    }

    private static void selectNumbers(final Suit suit, final List<Card> cards) {
        for (Rank rank : Rank.values()) {
            cards.add(new Card(suit, rank));
        }
    }
}