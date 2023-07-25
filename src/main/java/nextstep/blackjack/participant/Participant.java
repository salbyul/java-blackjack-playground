package nextstep.blackjack.participant;

import nextstep.blackjack.Card;

import java.util.ArrayList;
import java.util.List;

public abstract class Participant {

    private final List<Card> cards = new ArrayList<>();

    public void receiveCard(Card card) {
        this.cards.add(card);
    }

    public List<Card> getCards() {
        return this.cards;
    }
}
