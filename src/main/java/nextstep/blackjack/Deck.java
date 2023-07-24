package nextstep.blackjack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {

    private static final List<Card> deck = new ArrayList<>();

    static {
        init();
    }

    private static void init() {
        for (int indexOfShape = 0; indexOfShape < Card.NUMBER_OF_SHAPES; indexOfShape++) {
            addCardsOfShape(indexOfShape);
        }
        Collections.shuffle(deck);
    }

    private static void addCardsOfShape(final int indexOfShape) {
        for (int value = Card.VALUE_OF_ACE; value <= Card.NUMBER_OF_EACH_SHAPES; value++) {
            deck.add(new Card(Shape.getShapeByIndex(indexOfShape), value));
        }
    }

    public static int getNumberOfCards() {
        return deck.size();
    }
}
