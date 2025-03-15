package service;

import blackjack.Game;
import blackjack.card.CardDeck;
import blackjack.card.CardDeckFactory;
import blackjack.participant.Batting;
import blackjack.participant.Dealer;
import blackjack.participant.Name;
import blackjack.participant.Player;
import blackjack.participant.Players;
import java.util.List;

public class BlackJackService {

    public List<Name> createNames(List<String> names) {
        return names.stream()
                .map(Name::from)
                .toList();
    }

    public Player createBatting(Name name, int batting) {
        return Player.of(name, Batting.from(batting));
    }

    public Game createGame(List<Player> players) {
        CardDeck standard = setUpCardDeck();
        return Game.of(Players.from(players), Dealer.create(), standard);
    }

    private CardDeck setUpCardDeck() {
        CardDeckFactory cardDeckFactory = new CardDeckFactory();
        return cardDeckFactory.create();
    }

    public Game dealing(Game game) {
        return game.dealing();
    }

    public Boolean hit(Player player, Boolean isYes, CardDeck standard) {
        if(isYes){
            player.hit(standard);
        }
        return player.isBust();
    }
}
