package nextstep.blackjack.participant;

import nextstep.blackjack.Deck;

import java.util.List;

public class Players {

    public static final String ERROR_NO_PLAYER = "해당 플레이어가 존재하지 않습니다.";
    private final List<Player> playerList;

    public Players(final List<Player> playerList) {
        this.playerList = playerList;
    }

    public Player getPlayer(final String name) {
        return playerList.stream()
                .filter(player -> player.getName().equals(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ERROR_NO_PLAYER));
    }

    public void receiveCard() {
        playerList.forEach(player -> player.receiveCard(Deck.getCard()));
    }

    public List<Player> getPlayerList() {
        return playerList;
    }
}
