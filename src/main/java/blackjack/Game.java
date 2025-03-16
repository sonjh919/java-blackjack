package blackjack;

import blackjack.card.CardDeck;
import blackjack.participant.Dealer;
import blackjack.participant.Player;
import blackjack.participant.Players;
import java.util.Map;

public class Game {
    private static final int INITIAL_DEALING_COUNT = 2;

    private final Players players;
    private final Dealer dealer;

    private final CardDeck standard;

    public static Game of(Players players, Dealer dealer, CardDeck standard) {
        return new Game(players, dealer, standard);
    }

    private Game(final Players players, final Dealer dealer, final CardDeck standard) {
        this.players = players;
        this.dealer = dealer;
        this.standard = standard;
    }

    public Game dealing() {
        for (int i = 0; i < INITIAL_DEALING_COUNT; i++) {
            players.hit(standard);
            dealer.hit(standard);
        }
        return this;
    }

    public int calculateDealerResult() {
        Map<Player, Integer> profitOfPlayer = players.calculateProfit(dealer);

        int sum = 0;
        for (Integer value : profitOfPlayer.values()) {
            sum += value;
        }
        return -sum;
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
