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

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Player player = (Player) o;
        return betAmount == player.betAmount && Objects.equals(getName(), player.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), betAmount);
    }
}
