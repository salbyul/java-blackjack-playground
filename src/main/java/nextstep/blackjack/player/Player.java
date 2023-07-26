package nextstep.blackjack.player;

import nextstep.blackjack.card.Cards;
import nextstep.blackjack.state.Hit;
import nextstep.blackjack.state.State;

public class Player {

    private final String name;
    private State state;
    private int betAmount;

    public Player(final String name) {
        this.name = name;
        this.state = new Hit(new Cards());
    }

    public State getState() {
        return this.state;
    }

    public void bet(final int betAmount) {
        this.betAmount = betAmount;
    }

    public int getBetAmount() {
        return this.betAmount;
    }
}
