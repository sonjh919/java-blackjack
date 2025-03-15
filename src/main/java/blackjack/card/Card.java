package blackjack.card;

public class Card {
    private final Suit suit;
    private final Rank rank;

    public Card(final Suit suit, final Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public boolean isA() {
        return rank.isA();
    }

    public int getScore() {
        return rank.getScore();
    }

    public Suit getSuit() {
        return suit;
    }

    public Rank getRank() {
        return rank;
    }
}
