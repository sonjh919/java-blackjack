package service;

import blackjack.Game;
import blackjack.card.CardDeck;
import blackjack.card.CardDeckFactory;
import blackjack.participant.Batting;
import blackjack.participant.Dealer;
import blackjack.participant.Name;
import blackjack.participant.Participant;
import blackjack.participant.Player;
import blackjack.participant.Players;
import java.util.List;
import java.util.Map;

public class BlackJackService {

    public List<Name> createNames(List<String> names) {
        return names.stream()
                .map(Name::from)
                .toList();
    }

    public Player createBatting(Name name, int batting) {
        return Player.of(name, Batting.from(batting));
    }

    public Game createGame(List<Player> players) {
        CardDeck standard = setUpCardDeck();
        return Game.of(Players.from(players), Dealer.create(), standard);
    }

    private CardDeck setUpCardDeck() {
        CardDeckFactory cardDeckFactory = new CardDeckFactory();
        return cardDeckFactory.create();
    }

    public Game dealing(Game game) {
        return game.dealing();
    }

    public boolean hit(Player player, boolean isYes, CardDeck standard) {
        if (isYes) {
            player.hit(standard);
        }
        return player.isBust();
    }

    public boolean hit(Dealer dealer, CardDeck standard) {
        boolean canHit = dealer.isUnderThreshold();
        while (dealer.isUnderThreshold()) {
            dealer.hit(standard);
        }
        return canHit;
    }

    public int sum(Participant participant) {
        return participant.sum();
    }

    public int dealerProfit(Players players, Dealer dealer) {
        Map<Player, Integer> profitOfPlayer = players.calculateProfit(dealer);
        return profit(profitOfPlayer);
    }

    public int playerProfit(Player player, Dealer dealer) {
        return player.calculateProfit(dealer);
    }

    private int profit(Map<Player, Integer> profitOfPlayer) {
        int sum = 0;
        for (Integer value : profitOfPlayer.values()) {
            sum += value;
        }
        return -sum;
    }
}
