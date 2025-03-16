import blackjack.Game;
import blackjack.participant.Name;
import blackjack.participant.Player;
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
        Request<String> nameRequest = new Request<>(console.read());
        Response<List<Name>> nameResponse = blackJackController.createNames(new NameConverter().convert(nameRequest));

        List<Name> names = nameResponse.data();

        // 2. 배팅입력 및 플레이어 생성
        List<Player> players = new ArrayList<>();

        for (Name name : names) {
            console.askBatting(name.getName());
            Request<String> battingRequest = new Request<>(console.read());
            Response<Player> playerResponse = blackJackController.createBatting(name,
                    new BattingConverter().convert(battingRequest)); //todo: dto

            players.add(playerResponse.data());
        }

        // 3. 게임 생성
        Response<Game> gameResponse = blackJackController.createGame(players); //todo: Request wrapping & converter
        Game game = gameResponse.data();

        // 4. 카드 2장 나눠주기
        Response<Game> dealingResponse = blackJackController.dealing(game); //todo: dto, 한번에보내기 vs 나눠서보내기
        console.displayHand(dealingResponse.data());

        // 5. 플레이어 카드받기
        for (Player player : players) {
            while (true) {
                console.askHit(player.getName().getName());

                Request<String> answerRequest = new Request<>(console.read());
                boolean isYes = new AnswerConverter().convert(answerRequest); //todo: converter 중간 계층으로 빼기..?

                Response<Boolean> stop = blackJackController.hit(player, isYes,
                        game.getStandard()); //fixme: 에러처리 & standard 넘기기 싫음...
                console.displayHand(player);

                if (stop.data() || !isYes) {
                    break;
                }
            }
        }

        // 6. 딜러 카드받기
        Response<Boolean> isHit = blackJackController.hit(game.getDealer(), game.getStandard());
        console.displayHit(isHit.data());

        // 7. 딜러 합계 출력
        Response<Integer> dealerSumResponse = blackJackController.sum(game.getDealer());
        console.displayDealerResult(game.getDealer(), dealerSumResponse.data());

        // 8. 플레이어 합계 출력
        for (Player player : players) {
            Response<Integer> playerSumResponse = blackJackController.sum(player);
            console.displayPlayerResult(player, playerSumResponse.data());
        }

        // 수익 출력 intro
        console.displayProfit();

        // 9. 딜러 수익 출력
        Response<Integer> dealerProfitResponse = blackJackController.dealerProfit(game.getPlayers(), game.getDealer());
        console.displayDealerProfit(dealerProfitResponse.data());

        // 10. 플레이어 결과 출력
        for (Player player : players) {
            Response<Integer> playerProfitResponse = blackJackController.playerProfit(player, game.getDealer());
            console.displayPlayerProfit(player, playerProfitResponse.data());
        }

    }

}

