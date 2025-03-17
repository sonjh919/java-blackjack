package blackjack.participant;

import blackjack.card.CardDeck;
import blackjack.card.Hand;

public abstract class Participant {
    protected final Hand hand;

    public Participant() {
        this.hand = Hand.create();
    }

    public Hand dealing(CardDeck standard) {
        final int initialDealingCount = 2;
        for (int i = 0; i < initialDealingCount; i++) {
            hit(standard);
        }

        return getFirstCard();
    }

    public void hit(final CardDeck standard) {
        hand.addCard(standard.hitCard());
    }

    public boolean isBust() {
        return hand.isBust();
    }

    public int sum() {
        return hand.sumWithAce();
    }

    public boolean isBlackjack() {
        return hand.isBlackJackNumber() && isBlackJackCount();
    }

    public boolean isBlackJackCount() {
        return hand.isBlackJackCount();
    }

    public Hand getHand() {
        return hand;
    }

    protected abstract Hand getFirstCard();
}
