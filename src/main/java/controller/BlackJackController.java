package controller;

import blackjack.Game;
import blackjack.participant.Name;
import blackjack.participant.Player;
import java.util.List;
import service.BlackJackService;

public class BlackJackController { //todo: service
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
}
