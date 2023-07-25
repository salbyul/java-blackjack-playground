package nextstep.blackjack.participant;

public class Dealer extends Participant {

    private static final Dealer dealer = new Dealer();

    private Dealer() {}

    public static Dealer getDealer() {
        return dealer;
    };
}
