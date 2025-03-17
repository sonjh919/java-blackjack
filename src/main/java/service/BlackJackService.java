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
        return dealer.calculateProfit(players);
    }

    public int playerProfit(final Player player, final Dealer dealer) {
        return player.calculateProfit(dealer);
    }

}
