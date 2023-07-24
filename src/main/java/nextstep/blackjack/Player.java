package nextstep.blackjack;

import java.util.Objects;

public class Player {

    private final String name;
    private int betAmount;

    public Player(final String name) {
        this.name = name;
    }

    public void bet(final int amount) {
        this.betAmount = amount;
    }

    public int getBetAmount() {
        return this.betAmount;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Player player = (Player) o;
        return betAmount == player.betAmount && Objects.equals(name, player.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, betAmount);
    }
}
