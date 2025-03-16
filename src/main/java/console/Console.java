package console;

import blackjack.card.Hand;
import blackjack.participant.Dealer;
import blackjack.participant.Name;
import blackjack.participant.Player;
import java.util.List;
import protocol.Request;

public class Console {
    private static final Console CONSOLE = new Console();

    private final Input input;
    private final Output output;

    public static Console getInstance() {
        return CONSOLE;
    }

    private Console() {
        this.input = new Input();
        this.output = new Output();
    }

    public Request<String> read() {
        return input.read();
    }

    public void askNames() {
        output.name();
    }

    public void askBatting(final String name) {
        output.batting(name);
    }

    public void displayDealing(final List<Name> names) {
        output.dealing(names);
    }

    public void displayHand(final Hand dealerHand) {
        output.hand(dealerHand);
    }

    public void displayHand(final Name name, final Hand playerHand) {
        output.hand(name, playerHand);
    }

    public void displayHand(final Player player) {
        output.hand(player);
    }

    public void askHit(final String name) {
        output.hit(name);
    }

    public void displayHit(final boolean isHit) {
        output.hit(isHit);
    }

    public void displayDealerResult(final Dealer dealer, final int dealerResult) {
        output.displayDealerResult(dealer, dealerResult);
    }

    public void displayProfit() {
        output.displayProfit();
    }

    public void displayPlayerResult(final Player player, final int playersResult) {
        output.displayPlayerResult(player, playersResult);
    }

    public void displayDealerProfit(final int profit) {
        output.displayDealerProfit(profit);
    }

    public void displayPlayerProfit(final Player player, final int profit) {
        output.displayPlayerProfit(player, profit);
    }
}

