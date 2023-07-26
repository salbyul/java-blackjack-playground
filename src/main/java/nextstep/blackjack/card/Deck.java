package nextstep.blackjack.card;

import java.util.*;

public class Deck {

    private static final Stack<PlayingCard> deck;

    static {
        deck = new Stack<>();
        Arrays.stream(Denomination.values())
                .forEach(denomination -> Arrays.stream(Suit.values())
                        .forEach(suit -> deck.add(new PlayingCard(denomination, suit))));
        Collections.shuffle(deck);
    }

    public static int size() {
        return deck.size();
    }

    public static PlayingCard getCard() {
        return deck.pop();
    }
}
