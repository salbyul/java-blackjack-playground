package nextstep.blackjack.state;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Deck {

    private static final List<PlayingCard> deck;

    static {
        deck = new ArrayList<>();
        Arrays.stream(Denomination.values())
                .forEach(denomination -> Arrays.stream(Suit.values())
                        .forEach(suit -> deck.add(new PlayingCard(denomination, suit))));
        Collections.shuffle(deck);
    }

    public static int size() {
        return deck.size();
    }

    public static PlayingCard getCard() {
        return deck.get(0);
    }
}
