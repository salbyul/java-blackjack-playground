package nextstep.blackjack.player;

import nextstep.blackjack.card.Cards;
import nextstep.blackjack.card.Deck;
import nextstep.blackjack.state.Hit;
import nextstep.blackjack.state.State;

public abstract class Participant {

    private static final String ERROR_NAME = "이름은 한글자 이상 입력해야 합니다.";

    private final String name;
    private State state;

    protected Participant(final String name) {
        if (name.length() < 1) {
            throw new IllegalArgumentException(ERROR_NAME);
        }
        this.name = name;
        state = new Hit(new Cards());
    }

    public String getName() {
        return this.name;
    }

    public State getState() {
        return this.state;
    }

    public void setState(final State state) {
        this.state = state;
    }

    public void printCards() {
        final String result = getName() + ": " + state.cards().getCardListByString();
        System.out.println(result);
    }

    public void progress(final boolean canProgress) {
        if (state.isFinished()) {
            return;
        }
        if (canProgress) {
            setState(state.draw(Deck.getCard()));
            printCards();
            return;
        }
        setState(state.stay());
    }
}
