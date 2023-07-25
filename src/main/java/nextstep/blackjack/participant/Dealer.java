package nextstep.blackjack.participant;

public class Dealer extends Participant {

    private static final Dealer dealer = new Dealer();
    public static final String DEALER_NAME = "Dealer";

    private Dealer() {
        super(DEALER_NAME);
    }

    public static Dealer getDealer() {
        return dealer;
    };
}
