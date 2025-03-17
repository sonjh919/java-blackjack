package blackjack;

import blackjack.card.CardDeck;
import blackjack.card.CardDeckFactory;
import blackjack.card.Hand;
import blackjack.participant.Batting;
import blackjack.participant.Dealer;
import blackjack.participant.Name;
import blackjack.participant.Participant;
import blackjack.participant.Player;
import blackjack.participant.Players;
import java.util.List;
import java.util.Map;

public class BlackJack {

    public List<Name> createNames(final List<String> names) {
        return names.stream()
                .map(Name::from)
                .toList();
    }

    public Player createPlayer(final Name name, final int batting) {
        return Player.of(name, Batting.from(batting));
    }

    public CardDeck createCardDeck() {
        CardDeckFactory cardDeckFactory = new CardDeckFactory();
        return cardDeckFactory.create();
    }

    public Dealer createDealer() {
        return Dealer.create();
    }

    public Hand dealing(final Participant participant, final CardDeck standard) {
        final int initialDealingCount = 2;

        for (int i = 0; i < initialDealingCount; i++) {
            participant.hit(standard);
        }

        return participant.getFirstCard();
    }

    public boolean hit(final Player player, final boolean isYes, final CardDeck standard) {
        if (isYes) {
            player.hit(standard);
        }
        return player.isBust();
    }

    public boolean hit(final Dealer dealer, final CardDeck standard) {
        boolean canHit = dealer.isUnderThreshold();
        while (dealer.isUnderThreshold()) {
            dealer.hit(standard);
        }
        return canHit;
    }

    public int sum(final Participant participant) {
        return participant.sum();
    }

    public int dealerProfit(final Players players, final Dealer dealer) {
        Map<Player, Integer> profitOfPlayer = players.calculateProfit(dealer);
        return profit(profitOfPlayer);
    }

    public int playerProfit(final Player player, final Dealer dealer) {
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
