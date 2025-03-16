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

    public BlackJackController(BlackJackService blackJackService) {
        this.blackJackService = blackJackService;
    }

    public Response<List<Name>> createNames(List<String> names) {
        return new Response<>(blackJackService.createNames(names));
    }

    public Response<Player> createBatting(Name name, int batting) {
        return new Response<>(blackJackService.createBatting(name, batting));
    }

    public Response<CardDeck> createCardDeck() {
        return new Response<>(blackJackService.createCardDeck());
    }

    public Response<Dealer> createDealer() {
        return new Response<>(blackJackService.createDealer());
    }

    public Response<Hand> dealing(Participant participant, CardDeck standard) {
        return new Response<>(blackJackService.dealing(participant, standard));
    }

    public Response<Boolean> hit(Player player, boolean isYes, CardDeck standard) {
        return new Response<>(blackJackService.hit(player, isYes, standard));
    }

    public Response<Boolean> hit(Dealer dealer, CardDeck standard) {
        return new Response<>(blackJackService.hit(dealer, standard));
    }

    public Response<Integer> sum(Participant participant) {
        return new Response<>(blackJackService.sum(participant));
    }

    public Response<Integer> dealerProfit(Players players, Dealer dealer) {
        return new Response<>(blackJackService.dealerProfit(players, dealer));
    }

    public Response<Integer> playerProfit(Player player, Dealer dealer) {
        return new Response<>(blackJackService.playerProfit(player, dealer));
    }

}
