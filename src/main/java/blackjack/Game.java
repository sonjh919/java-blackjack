package blackjack;

import blackjack.card.CardDeck;
import blackjack.participant.Dealer;
import blackjack.participant.Players;

public class Game {
    private static final int INITIAL_HIT_COUNT = 2;

    private final Players players;
    private final Dealer dealer;

    private final CardDeck standard;

    public static Game of(Players players, Dealer dealer, CardDeck standard){
        return new Game(players, dealer, standard);
    }

    private Game(final Players players, final Dealer dealer, final CardDeck standard) {
        this.players = players;
        this.dealer = dealer;
        this.standard = standard;
    }

    public Players getPlayers() {
        return players;
    }

    public Dealer getDealer() {
        return dealer;
    }

    public CardDeck getStandard() {
        return standard;
    }
}
