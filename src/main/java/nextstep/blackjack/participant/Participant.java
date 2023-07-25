package nextstep.blackjack.participant;

import nextstep.blackjack.Card;

import java.util.ArrayList;
import java.util.List;

public abstract class Participant {

    private final List<Card> cards = new ArrayList<>();
    private final String name;

    public Participant(final String name) {
        this.name = name;
    }

    public void receiveCard(Card card) {
        this.cards.add(card);
    }

    public List<Card> getCards() {
        return this.cards;
    }

    public String getName() {
        return this.name;
    }
}
