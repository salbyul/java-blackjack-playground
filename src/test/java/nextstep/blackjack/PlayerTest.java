package nextstep.blackjack;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class PlayerTest {

    @Test
    @DisplayName("플레이어 생성 시 초기 카드 두 장 있는지 확인")
    void playerNameTest() {
        Player player = new Player("salbyul");
        assertThat(player.getState().cards().size()).isEqualTo(2);
    }
}
