package blackjack.card;

public record Card(Suit suit, Rank rank) {

    public boolean isA() {
        return rank.isA();
    }

    public int getScore() {
        return rank.getScore();
    }
}
