package nextstep.blackjack;

import nextstep.blackjack.participant.Player;
import nextstep.blackjack.view.InputView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class InputViewTest {

    @BeforeEach
    void setUp() {
        Deck.init();
    }

    @Test
    @DisplayName("플레이어의 이름 입력받기")
    void getPlayerList() {
        InputView inputView = new InputView();
        List<Player> playerList = inputView.transferToPlayerList("pobi, jason");
        assertThat(playerList).containsExactly(new Player("pobi"), new Player("jason"));
    }

    @Test
    @DisplayName("플레이어의 이름 입력이 존재하지 않을 시")
    void getNoPlayer() {
        InputView inputView = new InputView();
        assertThatThrownBy(() -> inputView.transferToPlayerList("")).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름은 적어도 한글자 이상 입력되어야 합니다.");
    }

    @Test
    @DisplayName("중복된 이름이 있을 경우")
    void duplicatePlayerNames() {
        InputView inputView = new InputView();
        assertThatThrownBy(() -> inputView.transferToPlayerList("salbyul, salbyul"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름은 중복될 수 없습니다.");
    }

    @Test
    @DisplayName("배팅 금액 입력받기")
    void getBetAmount() {
        Player player = new Player("pobi");
        player.bet(10000);
        assertThat(player.getBetAmount()).isEqualTo(10000);
    }
}
