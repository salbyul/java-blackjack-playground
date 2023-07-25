package nextstep.blackjack.participant;

import java.util.Objects;

public class Player extends Participant {

    private static final String ERROR_NO_PLAYER_NAME = "이름은 적어도 한글자 이상 입력되어야 합니다.";

    private int betAmount;

    public Player(final String name) {
        super(name);
        if (name.length() == 0) {
            throw new IllegalArgumentException(ERROR_NO_PLAYER_NAME);
        }
    }

    public void bet(final int amount) {
        this.betAmount = amount;
    }

    public int getBetAmount() {
        return this.betAmount;
    }

    public void setIncome() {
        Dealer dealer = Dealer.getDealer();
        int dealerResultValue = dealer.getResultValue();
        int resultValue = getResultValue();

        double income = calculateIncome(dealerResultValue, resultValue);
        setIncome(income);
    }

    private double calculateIncome(final int dealerResultValue, final int resultValue) {
        if (dealerResultValue > MAXIMUM_VALUE) {
            return getBetAmount();
        } else if (resultValue > MAXIMUM_VALUE) {
            return getBetAmount() * -1;
        } else if (dealerResultValue < MAXIMUM_VALUE && resultValue == MAXIMUM_VALUE && hasTwoCards()) {
            return getBetAmount() * 1.5;
        } else if (resultValue > dealerResultValue) {
            return getBetAmount();
        } else if (resultValue == dealerResultValue) {
            return 0;
        }
        return getBetAmount() * -1;
    }

    private boolean hasTwoCards() {
        return getCards().size() == 2;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Player player = (Player) o;
        return getBetAmount() == player.getBetAmount();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBetAmount());
    }
}
