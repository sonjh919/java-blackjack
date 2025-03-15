import blackjack.Batting;
import blackjack.Name;
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
        Response<List<Name>> names = blackJackController.createNames(new NameConverter().convert(nameRequest));

        // 2. 배팅입력
        List<Batting> battings = new ArrayList<>();

        for (Name name : names.getData()) {
            console.askBatting(name.getName());
            Request<String> battingRequest = new Request<>(console.read());
            Response<Batting> batting = blackJackController.createBatting(new BattingConverter().convert(battingRequest));

            battings.add(batting.getData());
        }

    }


}

