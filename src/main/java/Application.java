import blackjack.card.CardDeck;
import blackjack.card.Hand;
import blackjack.participant.Dealer;
import blackjack.participant.Name;
import blackjack.participant.Player;
import blackjack.participant.Players;
import console.Console;
import controller.BlackJackController;
import converter.AnswerConverter;
import converter.BattingConverter;
import converter.NameConverter;
import java.util.ArrayList;
import java.util.List;
import protocol.Request;
import protocol.Response;
import service.BlackJackService;

public class Application {
    public static void main(String[] args) {
        // init
        Console console = Console.getInstance();
        BlackJackController blackJackController = new BlackJackController(new BlackJackService());

        // 1. 이름입력
        console.askNames();
        Request<String> nameRequest = console.read();
        Response<List<Name>> nameResponse = blackJackController.createNames(new NameConverter().convert(nameRequest));

        List<Name> names = nameResponse.data();

        // 2. 배팅입력 및 플레이어 생성
        List<Player> players = new ArrayList<>();

        for (Name name : names) {
            console.askBatting(name.getName());
            Request<String> battingRequest = console.read();
            Response<Player> playerResponse = blackJackController.createBatting(name,
                    new BattingConverter().convert(battingRequest));

            players.add(playerResponse.data());
        }

        // 3. 카드 생성
        Response<CardDeck> cardDeckResponse = blackJackController.createCardDeck();
        CardDeck standard = cardDeckResponse.data();

        // 4. 딜러 생성
        Response<Dealer> dealerResponse = blackJackController.createDealer();
        Dealer dealer = dealerResponse.data();

        // 4. 카드 2장 나눠주기 intro
        console.displayDealing(names);

        // 5. 딜러 첫 카드 받기
        Response<Hand> dealingDealerResponse = blackJackController.dealing(dealer, standard);
        console.displayHand(dealingDealerResponse.data());

        // 5. 플레이어 첫 카드 받기
        for (Player player : players) {
            Response<Hand> dealingPlayerResponse = blackJackController.dealing(player, standard);
            console.displayHand(player.getName(), dealingPlayerResponse.data());
        }

        // 6. 플레이어 카드받기
        for (Player player : players) {
            while (true) {
                console.askHit(player.getName().getName());

                Request<String> answerRequest = console.read();
                boolean isYes = new AnswerConverter().convert(answerRequest);

                Response<Boolean> stop = blackJackController.hit(player, isYes,
                        standard);
                console.displayHand(player);

                if (stop.data() || !isYes) {
                    break;
                }
            }
        }

        // 7. 딜러 카드받기
        Response<Boolean> isHit = blackJackController.hit(dealer, standard);
        console.displayHit(isHit.data());

        // 8. 딜러 합계 출력
        Response<Integer> dealerSumResponse = blackJackController.sum(dealer);
        console.displayDealerResult(dealer, dealerSumResponse.data());

        // 9. 플레이어 합계 출력
        for (Player player : players) {
            Response<Integer> playerSumResponse = blackJackController.sum(player);
            console.displayPlayerResult(player, playerSumResponse.data());
        }

        // 10. 수익 출력 intro
        console.displayProfit();

        // 11. 딜러 수익 출력
        Response<Integer> dealerProfitResponse = blackJackController.dealerProfit(Players.from(players), dealer);
        console.displayDealerProfit(dealerProfitResponse.data());

        // 12. 플레이어 결과 출력
        for (Player player : players) {
            Response<Integer> playerProfitResponse = blackJackController.playerProfit(player, dealer);
            console.displayPlayerProfit(player, playerProfitResponse.data());
        }

    }

}

