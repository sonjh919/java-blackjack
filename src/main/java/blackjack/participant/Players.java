package blackjack.participant;

import blackjack.card.CardDeck;
import java.util.List;

public class Players {
    private static final int MAXIMUM_PLAYER_NUMBER = 6;

    private final List<Player> players;

    public static Players from(final List<Player> players) {
        return new Players(players);
    }

    private Players(final List<Player> players) {
        this.players = players;
    }

    public void hit(final CardDeck standard) {
        players.forEach(player -> player.hit(standard));
    }

    public List<Player> getPlayers() {
        return players;
    }

}