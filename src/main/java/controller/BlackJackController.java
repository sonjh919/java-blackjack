package controller;

import blackjack.Batting;
import blackjack.Name;
import java.util.List;

public class BlackJackController {

    public Response<List<Name>> createNames(List<String> names) {
        return new Response<>(names.stream()
                .map(Name::from)
                .toList());
    }

    public Response<Batting> createBatting(int batting) {
        return new Response<>(Batting.from(batting));
    }
}
