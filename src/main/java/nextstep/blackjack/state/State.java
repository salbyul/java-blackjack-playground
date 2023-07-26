package nextstep.blackjack.state;

public interface State {

    Cards cards();

    State draw(final PlayingCard card);

    State stay();

    boolean isFinished();
}
