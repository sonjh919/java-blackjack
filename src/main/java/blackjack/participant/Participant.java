package blackjack.participant;

import blackjack.card.Hand;

public abstract class Participant {
    protected final Hand hand;

    public Participant() {
        this.hand = Hand.create();
    }

    public Hand getHand() {
        return hand;
    }
}