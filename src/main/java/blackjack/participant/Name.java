package blackjack.participant;

public class Name {
    private String name;

    public static Name from(String name){
        return new Name(name);
    }

    private Name(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
