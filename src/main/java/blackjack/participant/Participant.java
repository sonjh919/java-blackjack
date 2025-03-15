package blackjack.participant;

import blackjack.card.CardDeck;
import blackjack.card.Hand;

public abstract class Participant {
    protected final Hand hand;

    public Participant() {
        this.hand = Hand.create();
    }

    public void hit(final CardDeck standard) {
        hand.addCard(standard.hitCard());
    }

    public boolean isBust() {
        return hand.isBust();
    }

    public Hand getHand() {
        return hand;
    }

    public abstract Hand getFirstCard();
}