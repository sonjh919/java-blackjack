package console;

import java.util.Scanner;

public class Input {
    Scanner scanner;

    public Input() {
        this.scanner = new Scanner(System.in);
    }

    public String read(){
        return scanner.nextLine();
    }
}
