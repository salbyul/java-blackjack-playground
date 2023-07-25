package nextstep.blackjack;

import nextstep.blackjack.participant.Dealer;
import nextstep.blackjack.participant.Player;
import nextstep.blackjack.participant.Players;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class PlayerTest {

    @Test
    @DisplayName("플레이어가 카드를 제대로 받는지")
    void getCard() {
        Player player = new Player("salbyul");
        player.receiveCard(new Card(Shape.HEART, 3));
        List<Card> cards = player.getCards();
        assertThat(cards).containsExactly(new Card(Shape.HEART, 3));
    }

    @Test
    @DisplayName("처음 카드 지급으로 2장의 카드를 받는지")
    void getTwoCards() {
        Players players = new Players(Arrays.asList(new Player("salbyul"), new Player("coco")));
        Player salbyul = players.getPlayer("salbyul");
        Player coco = players.getPlayer("coco");
        Dealer dealer = Dealer.getDealer();

        Deck.giveTwoCards(players);

        assertThat(salbyul.getCards()).size().isEqualTo(2);
        assertThat(coco.getCards()).size().isEqualTo(2);
        assertThat(dealer.getCards()).size().isEqualTo(2);
    }
}
