package nextstep.blackjack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Deck {

    private static final List<PlayingCard> deck;

    static {
        deck = new ArrayList<>();
        Arrays.stream(Denomination.values())
                .forEach(denomination -> Arrays.stream(Suit.values())
                        .forEach(suit -> deck.add(new PlayingCard(denomination, suit))));
    }

    public static int size() {
        return deck.size();
    }
}
