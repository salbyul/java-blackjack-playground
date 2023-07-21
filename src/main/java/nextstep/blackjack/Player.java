package nextstep.blackjack;

import java.util.Objects;

public class Player {

    private final String name;
    private int amount;

    public Player(final String name) {
        this.name = name;
    }

    public void bet(final int amount) {
        this.amount = amount;
    }

    public int getBetAmount() {
        return this.amount;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Player player = (Player) o;
        return amount == player.amount && Objects.equals(name, player.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, amount);
    }
}
