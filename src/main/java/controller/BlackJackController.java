package controller;

import blackjack.card.CardDeck;
import blackjack.card.Hand;
import blackjack.participant.Dealer;
import blackjack.participant.Name;
import blackjack.participant.Participant;
import blackjack.participant.Player;
import blackjack.participant.Players;
import java.util.List;
import service.BlackJackService;

public class BlackJackController {
    BlackJackService blackJackService;

    public BlackJackController(final BlackJackService blackJackService) {
        this.blackJackService = blackJackService;
    }

    public List<Name> createNames(final List<String> names) {
        return blackJackService.createNames(names);
    }

    public Player createBatting(final Name name, final int batting) {
        return blackJackService.createBatting(name, batting);
    }

    public CardDeck createCardDeck() {
        return blackJackService.createCardDeck();
    }

    public Dealer createDealer() {
        return blackJackService.createDealer();
    }

    public Hand dealing(final Participant participant, final CardDeck standard) {
        return blackJackService.dealing(participant, standard);
    }

    public Boolean hit(final Player player, final boolean isYes, final CardDeck standard) {
        return blackJackService.hit(player, isYes, standard);
    }

    public Boolean hit(final Dealer dealer, final CardDeck standard) {
        return blackJackService.hit(dealer, standard);
    }

    public int sum(final Participant participant) {
        return blackJackService.sum(participant);
    }

    public int dealerProfit(final Players players, final Dealer dealer) {
        return blackJackService.dealerProfit(players, dealer);
    }

    public int playerProfit(final Player player, final Dealer dealer) {
        return blackJackService.playerProfit(player, dealer);
    }

}
