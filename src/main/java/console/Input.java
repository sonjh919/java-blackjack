package console;

import java.util.Scanner;
import protocol.Request;

public class Input {
    Scanner scanner;

    public Input() {
        this.scanner = new Scanner(System.in);
    }

    public Request<String> read() {
        return new Request<>(scanner.nextLine());
    }
}
