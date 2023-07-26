package nextstep.blackjack;

import nextstep.blackjack.player.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class PlayerTest {

    private static Player player;

    @BeforeEach
    void setUp() {
        player = new Player("salbyul");
    }

    @Test
    @DisplayName("플레이어 생성 시 초기 카드 두 장 있는지 확인")
    void playerNameTest() {
        assertThat(player.getState().cards().size()).isEqualTo(2);
    }

    @Test
    @DisplayName("플레이어 배팅금액 확인")
    void playerBetAmountTest() {
        player.bet(10000);
        assertThat(player.getBetAmount()).isEqualTo(10000);
    }
}
