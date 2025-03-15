package blackjack.participant;

import blackjack.card.Hand;

public class Dealer extends Participant {
    private static final int DEALER_DRAW_THRESHOLD = 16;

    public static Dealer create(){
        return new Dealer();
    }

    private Dealer() {
        super();
    }

    @Override
    public Hand getFirstCard() {
        return hand.getExceptHidden();
    }

}
