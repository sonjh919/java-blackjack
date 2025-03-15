import blackjack.Batting;
import blackjack.Name;
import blackjack.Player;
import console.Console;
import controller.BlackJackController;
import controller.Response;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // init
        Console console = Console.getInstance();
        BlackJackController blackJackController = new BlackJackController();

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
            Response<Player> player = blackJackController.createBatting(name, new BattingConverter().convert(battingRequest));

            players.add(player.getData());
        }



    }


}

