package blackjack.match;

import blackjack.participant.Dealer;
import blackjack.participant.Player;

public enum Match {
    WIN(2),
    BLACKJACK(2.5),
    DRAW(1),
    LOSE(0);

    private final double rate;

    Match(final double rate) {
        this.rate = rate;
    }

    public double getRate() {
        return rate;
    }

    public static Match calculateResult(final Player player, final Dealer dealer) {
        if(isWin(player,dealer))return WIN;
        if(isBlackJack(player,dealer))return BLACKJACK;
        if(isDraw(player,dealer))return DRAW;
        if(isLose(player,dealer))return LOSE;

        throw new IllegalStateException();
    }

    private static boolean isLose(Player player, Dealer dealer) {
        return (!dealer.isBust() && dealer.sum() > player.sum()) || player.isBust();
    }

    private static boolean isBlackJack(Player player, Dealer dealer) {
        return player.isBlackjack() && !dealer.isBlackjack();
    }

    private static boolean isDraw(Player player, Dealer dealer) {
        return player.isBlackjack() && dealer.isBlackjack() || player.sum() == dealer.sum() && !player.isBust();
    }

    private static boolean isWin(Player player, Dealer dealer) {
        return dealer.sum() < player.sum() && !player.isBust() || dealer.isBust() && !player.isBust();
    }
}