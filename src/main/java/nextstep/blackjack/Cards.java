package nextstep.blackjack;

import java.util.ArrayList;
import java.util.List;

public class Cards {

    private final List<PlayingCard> cards = new ArrayList<>();

    public Cards() {
        this.cards.add(Deck.getCard());
        this.cards.add(Deck.getCard());
    }

    public int size() {
        return this.cards.size();
    }
}
