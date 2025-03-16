package console;

import static blackjack.card.Rank.ACE;
import static blackjack.card.Rank.JACK;
import static blackjack.card.Rank.KING;
import static blackjack.card.Rank.QUEEN;

import blackjack.Game;
import blackjack.card.Card;
import blackjack.card.Hand;
import blackjack.card.Rank;
import blackjack.card.Suit;
import blackjack.participant.Dealer;
import blackjack.participant.Name;
import blackjack.participant.Player;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Output {
    private static final String NEW_LINE = System.lineSeparator();

    private static final Map<Rank, String> NUMBER_SYMBOL_MAP = new HashMap<>(
            Map.of(ACE, "A", QUEEN, "Q", JACK, "J", KING, "K"));

    public void name() {
        System.out.println("게임에 참여할 사람의 이름을 입력하세요.(쉼표 기준으로 분리)");
    }

    public void batting(String name) {
        System.out.printf("%s의 배팅 금액은?" + NEW_LINE, name);
    }

    public void hand(Game game) {
        List<String> names = game.getPlayers().getPlayers().stream()
                .map(Player::getName)
                .map(Name::getName)
                .toList();

        System.out.printf("딜러와 %s에게 2장을 나누었습니다.%n", String.join(",", names));
        hand(game.getDealer());
        System.out.print(NEW_LINE);

        for (Player player : game.getPlayers().getPlayers()) {
            hand(player);
            System.out.print(NEW_LINE);
        }
    }

    public void hand(Dealer dealer) {
        System.out.print("딜러 카드: " + printParticipantDeck(dealer.getFirstCard()));
    }

    public void hand(Player player) {
        System.out.printf("%s카드: ", player.getName().getName());
        System.out.print(printParticipantDeck(player.getHand()));
    }

    public String printParticipantDeck(final Hand hand) {
        List<String> cardSymbols = new ArrayList<>();
        for (Card card : hand.getCards()) {
            cardSymbols.add(toSymbol(card));
        }
        return String.join(",", cardSymbols);
    }

    private static String toSymbol(final Card card) {
        Rank rank = card.getRank();
        Suit suit = card.getSuit();
        return NUMBER_SYMBOL_MAP.getOrDefault(rank, String.valueOf(rank.getScore())) + suit;
    }

    public void hit(String name) {
        System.out.printf(NEW_LINE + "%s는 한장의 카드를 더 받겠습니까?(예는 y, 아니오는 n)", name);
        System.out.print(NEW_LINE);
    }

    public void hit(boolean isHit) {
        if (isHit) {
            System.out.println("딜러는 16이하라 한장의 카드를 더 받았습니다.");
        }
    }

    public void displayDealerResult(Dealer dealer, int dealerResult) {
        System.out.print(NEW_LINE);
        hand(dealer);
        System.out.printf(" - 결과: %d", dealerResult);
    }

    public void displayPlayerResult(Player player, int playersResult) {
        System.out.print(NEW_LINE);
        hand(player);
        System.out.printf(" - 결과: %d", playersResult);
    }

    public void displayProfit() {
        System.out.println(NEW_LINE + "## 최종 수익");
    }

    public void displayDealerProfit(int profit) {
        System.out.println("딜러: " + profit);
    }

    public void displayPlayerProfit(Player player, int profit) {
        System.out.println(player.getName().getName() + ": " + profit);
    }
}
