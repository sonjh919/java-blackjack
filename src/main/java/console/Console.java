package console;

import blackjack.Game;

public class Console {
    private static Console CONSOLE = new Console();

    private Input input;
    private Output output;

    public static Console getInstance(){
        return CONSOLE;
    }

    private Console() {
        this.input = new Input();
        this.output = new Output();
    }

    public String read(){
        return input.read();
    }

    public void askNames(){
        output.name();
    }

    public void askBatting(String name){
        output.batting(name);
    }

    public void displayDealing(Game game) {
        output.dealing(game);
    }
}

