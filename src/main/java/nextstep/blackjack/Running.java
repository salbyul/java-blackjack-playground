package nextstep.blackjack;

public class Running extends Started {

    public Running(final Cards cards) {
        super(cards);
    }

    @Override
    public State draw(final PlayingCard card) {
        return null;
    }

    @Override
    public State stay() {
        return null;
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}
