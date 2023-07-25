package nextstep.blackjack;

import nextstep.blackjack.participant.Dealer;
import nextstep.blackjack.participant.Players;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {

    private static final List<Card> deck = new ArrayList<>();
    private static final Dealer dealer = Dealer.getDealer();
    private static final String ERROR_NO_CARD = "덱에 카드가 없습니다.";

    static {
        init();
    }

    public static void init() {
        deck.clear();
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

    public static Card getCard() {
        if (deck.size() == 0) {
            throw new IllegalArgumentException(ERROR_NO_CARD);
        }
        Card card = deck.get(0);
        deck.remove(0);
        return card;
    }

    public static void giveTwoCards(final Players players) {
        for (int i = 0; i < 2; i++) {
            dealer.receiveCard(Deck.getCard());
            players.receiveCard();
        }
    }
}
