import blackjack.BlackJack;
import blackjack.card.CardDeck;
import blackjack.card.Hand;
import blackjack.participant.Dealer;
import blackjack.participant.Name;
import blackjack.participant.Player;
import blackjack.participant.Players;
import console.Console;
import converter.AnswerConverter;
import converter.BattingConverter;
import converter.NameConverter;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // init
        Console console = Console.getInstance();
        BlackJack blackJack = new BlackJack();

        // 1. 이름입력
        console.askNames();
        List<String> names =new NameConverter().convert(console.read());

        // 2. 배팅입력 및 플레이어 생성
        List<Player> players = new ArrayList<>();

        for (String name : names) {
            console.askBatting(name);
            Player player = blackJack.createPlayer(name,
                    new BattingConverter().convert(console.read()));

            players.add(player);
        }

        // 3. 카드 생성
        CardDeck standard = blackJack.createCardDeck();

        // 4. 딜러 생성
        Dealer dealer = blackJack.createDealer();

        // 4. 카드 2장 나눠주기 intro
        console.displayDealing(names);

        // 5. 딜러 첫 카드 받기
        Hand dealingDealer = blackJack.dealing(dealer, standard);
        console.displayHand(dealingDealer);

        // 5. 플레이어 첫 카드 받기
        for (Player player : players) {
            Hand dealingPlayer = blackJack.dealing(player, standard);
            console.displayHand(player.getName(), dealingPlayer);
        }

        // 6. 플레이어 카드받기
        for (Player player : players) {
            while (true) {
                console.askHit(player.getName().getName());
                boolean isYes = new AnswerConverter().convert(console.read());

                boolean isStop = blackJack.hit(player, isYes,
                        standard);
                console.displayHand(player);

                if (isStop || !isYes) {
                    break;
                }
            }
        }

        // 7. 딜러 카드받기
        boolean isHit = blackJack.hit(dealer, standard);
        console.displayHit(isHit);

        // 8. 딜러 합계 출력
        int dealerSum = blackJack.sum(dealer);
        console.displayDealerResult(dealer, dealerSum);

        // 9. 플레이어 합계 출력
        for (Player player : players) {
            int playerSum = blackJack.sum(player);
            console.displayPlayerResult(player, playerSum);
        }

        // 10. 수익 출력 intro
        console.displayProfit();

        // 11. 딜러 수익 출력
        int dealerProfit = blackJack.dealerProfit(Players.from(players), dealer);
        console.displayDealerProfit(dealerProfit);

        // 12. 플레이어 결과 출력
        for (Player player : players) {
            int playerProfit = blackJack.playerProfit(player, dealer);
            console.displayPlayerProfit(player, playerProfit);
        }

    }

}

