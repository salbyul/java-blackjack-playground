package nextstep.blackjack;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class InputViewTest {

    @Test
    void getPlayerList() {
        InputView inputView = new InputView();
        List<Player> playerList = inputView.getPlayerNames("pobi, jason");
        assertThat(playerList).containsExactly(new Player("pobi"), new Player("jason"));
    }

    @Test
    void getBetAmount() {
        Player player = new Player("pobi");
        player.bet(10000);
        assertThat(player.getBetAmount()).isEqualTo(10000);
    }
}
