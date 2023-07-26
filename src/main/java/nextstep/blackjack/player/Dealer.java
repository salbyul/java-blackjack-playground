package nextstep.blackjack.player;

public class Dealer extends Participant {

    public static final String DEALER_NAME = "딜러";
    public static final Dealer INSTANCE = new Dealer(DEALER_NAME);

    private Dealer(final String name) {
        super(name);
    }
}
