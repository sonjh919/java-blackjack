package console;

import blackjack.card.Hand;
import blackjack.participant.Dealer;
import blackjack.participant.Name;
import blackjack.participant.Player;
import java.util.List;

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

    public String read() {
        return input.read();
    }

    public void askNames() {
        output.name();
    }

    public void askBatting(String name) {
        output.batting(name);
    }

    public void displayDealing(List<Name> names) {
        output.dealing(names);
    }

    public void displayHand(Hand dealerHand) {
        output.hand(dealerHand);
    }

    public void displayHand(Name name, Hand playerHand) {
        output.hand(name, playerHand);
    }

    public void displayHand(Player player) {
        output.hand(player);
    }

    public void askHit(String name) {
        output.hit(name);
    }

    public void displayHit(boolean isHit) {
        output.hit(isHit);
    }

    public void displayDealerResult(Dealer dealer, int dealerResult) {
        output.displayDealerResult(dealer, dealerResult);
    }

    public void displayProfit() {
        output.displayProfit();
    }

    public void displayPlayerResult(Player player, int playersResult) {
        output.displayPlayerResult(player, playersResult);
    }

    public void displayDealerProfit(int profit) {
        output.displayDealerProfit(profit);
    }

    public void displayPlayerProfit(Player player, int profit) {
        output.displayPlayerProfit(player, profit);
    }
}

