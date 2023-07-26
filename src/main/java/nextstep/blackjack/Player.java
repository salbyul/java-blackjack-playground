package nextstep.blackjack;

public class Player {

    private final String name;
    private State state;

    public Player(final String name) {
        this.name = name;
        this.state = new Hit(new Cards());
    }

    public State getState() {
        return this.state;
    }
}
