package blackjack.participant;

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

    public LinkedHashMap<Player, Integer> calculateProfit(final Dealer dealer) {
        LinkedHashMap<Player, Integer> profitOfPlayer = new LinkedHashMap<>();

        for (Player player : players) {
            profitOfPlayer.put(player, player.calculateProfit(dealer));
        }

        return profitOfPlayer;
    }

}