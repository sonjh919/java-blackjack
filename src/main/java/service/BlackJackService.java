package service;

import blackjack.card.CardDeck;
import blackjack.card.CardDeckFactory;
import blackjack.card.Hand;
import blackjack.participant.Batting;
import blackjack.participant.Dealer;
import blackjack.participant.Name;
import blackjack.participant.Participant;
import blackjack.participant.Player;
import blackjack.participant.Players;
import java.util.Map;

public class BlackJackService {

    public Player createPlayer(final String name, final int batting) {
        return Player.of(Name.from(name), Batting.from(batting));
    }

    public CardDeck createCardDeck() {
        CardDeckFactory cardDeckFactory = new CardDeckFactory();
        return cardDeckFactory.create();
    }

    public Dealer createDealer() {
        return Dealer.create();
    }

    public Hand dealing(final Participant participant, final CardDeck standard) {
        return participant.dealing(standard);
    }

    public boolean hit(final Player player, final boolean isYes, final CardDeck standard) { //todo: move player
        if (isYes) {
            player.hit(standard);
        }
        return player.isBust();
    }

    public boolean hit(final Dealer dealer, final CardDeck standard) { //todo: move dealer
        boolean canHit = dealer.isUnderThreshold();
        while (dealer.isUnderThreshold()) {
            dealer.hit(standard);
        }
        return canHit;
    }

    public int sum(final Participant participant) {
        return participant.sum();
    }

    public int dealerProfit(final Players players, final Dealer dealer) { //todo: move players
        Map<Player, Integer> profitOfPlayer = players.calculateProfit(dealer);
        return profit(profitOfPlayer);
    }

    public int playerProfit(final Player player, final Dealer dealer) { //todo: move player
        return player.calculateProfit(dealer);
    }

    private int profit(final Map<Player, Integer> profitOfPlayer) {
        int sum = 0;
        for (Integer value : profitOfPlayer.values()) {
            sum += value;
        }
        return -sum;
    }

}
