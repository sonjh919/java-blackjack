import blackjack.Game;
import blackjack.participant.Name;
import blackjack.participant.Player;
import console.Console;
import controller.BlackJackController;
import controller.Response;
import java.util.ArrayList;
import java.util.List;
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

        List<Name> names = nameResponse.getData();

        // 2. 배팅입력 및 플레이어 생성
        List<Player> players = new ArrayList<>();

        for (Name name : names) {
            console.askBatting(name.getName());
            Request<String> battingRequest = new Request<>(console.read());
            Response<Player> player = blackJackController.createBatting(name, new BattingConverter().convert(battingRequest)); //todo: dto

            players.add(player.getData());
        }

        // 3. 게임 생성
        Response<Game> gameResponse = blackJackController.createGame(players); //todo: Request wrapping & converter
        Game game = gameResponse.getData();

        // 4. 카드 2장 나눠주기
        Response<Game> dealingResponse = blackJackController.dealing(game); //todo: dto
        console.displayHand(dealingResponse.getData());

        // 5. 카드 더 받을거니?
        for (Player player : players) {
            while(true){
                console.askHit(player.getName().getName());

                Request<String> answerRequest = new Request<>(console.read());
                boolean isYes = new AnswerConverter().convert(answerRequest); //todo: converter 중간 계층으로 빼기..?

                Response<Boolean> stop = blackJackController.hit(player, isYes, game.getStandard()); //todo: 에러처리 & standard 넘기기 싫음...
                console.displayHand(player);

                if(stop.getData() || !isYes)break;
            }

        }

    }


}

