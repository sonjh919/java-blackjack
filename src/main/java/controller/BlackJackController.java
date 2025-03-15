package controller;

import blackjack.Batting;
import blackjack.Name;
import blackjack.Player;
import java.util.List;

public class BlackJackController {

    public Response<List<Name>> createNames(List<String> names) {
        return new Response<>(names.stream()
                .map(Name::from)
                .toList());
    }

    public Response<Player> createBatting(Name name, int batting) {
        return new Response<>(Player.of(name, Batting.from(batting)));
    }
}
