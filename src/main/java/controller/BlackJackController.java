package controller;

import blackjack.card.CardDeck;
import blackjack.card.Hand;
import blackjack.participant.Dealer;
import blackjack.participant.Name;
import blackjack.participant.Participant;
import blackjack.participant.Player;
import blackjack.participant.Players;
import java.util.List;
import protocol.Response;
import service.BlackJackService;

public class BlackJackController {
    BlackJackService blackJackService;

    public BlackJackController(final BlackJackService blackJackService) {
        this.blackJackService = blackJackService;
    }

    public Response<List<Name>> createNames(final List<String> names) {
        return new Response<>(blackJackService.createNames(names));
    }

    public Response<Player> createBatting(final Name name, final int batting) {
        return new Response<>(blackJackService.createBatting(name, batting));
    }

    public Response<CardDeck> createCardDeck() {
        return new Response<>(blackJackService.createCardDeck());
    }

    public Response<Dealer> createDealer() {
        return new Response<>(blackJackService.createDealer());
    }

    public Response<Hand> dealing(final Participant participant, final CardDeck standard) {
        return new Response<>(blackJackService.dealing(participant, standard));
    }

    public Response<Boolean> hit(final Player player, final boolean isYes, final CardDeck standard) {
        return new Response<>(blackJackService.hit(player, isYes, standard));
    }

    public Response<Boolean> hit(final Dealer dealer, final CardDeck standard) {
        return new Response<>(blackJackService.hit(dealer, standard));
    }

    public Response<Integer> sum(final Participant participant) {
        return new Response<>(blackJackService.sum(participant));
    }

    public Response<Integer> dealerProfit(final Players players, final Dealer dealer) {
        return new Response<>(blackJackService.dealerProfit(players, dealer));
    }

    public Response<Integer> playerProfit(final Player player, final Dealer dealer) {
        return new Response<>(blackJackService.playerProfit(player, dealer));
    }

}
