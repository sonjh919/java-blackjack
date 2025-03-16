package blackjack.participant;

import blackjack.card.CardDeck;
import java.util.LinkedHashMap;
import java.util.List;

public class Players {
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

    public LinkedHashMap<Player, Integer> calculateProfit(Dealer dealer) {
        LinkedHashMap<Player, Integer> profitOfPlayer = new LinkedHashMap<>();

        for (Player player : players) {
            profitOfPlayer.put(player, player.calculateProfit(dealer));
        }

        return profitOfPlayer;
    }

    public List<Player> getPlayers() {
        return players;
    }

}