package controller;

import blackjack.Game;
import blackjack.card.CardDeck;
import blackjack.participant.Dealer;
import blackjack.participant.Name;
import blackjack.participant.Participant;
import blackjack.participant.Player;
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

    public Response<Game> createGame(List<Player> players) {
        return new Response<>(blackJackService.createGame(players));
    }

    public Response<Game> dealing(Game game) {
        return new Response<>(blackJackService.dealing(game));
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

    public Response<Integer> dealerProfit(Game game) {
        return new Response<>(blackJackService.dealerProfit(game));
    }

    public Response<Integer> playerProfit(Player player, Dealer dealer) {
        return new Response<>(blackJackService.playerProfit(player, dealer));
    }
}
