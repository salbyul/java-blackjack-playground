package nextstep.blackjack;

import nextstep.blackjack.participant.Dealer;
import nextstep.blackjack.participant.Player;
import nextstep.blackjack.participant.Players;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class PlayerTest {

    static Player pobi;
    static Player salbyul;
    static Dealer dealer;

    @BeforeEach
    void setUp() {
        clearDealerCard();
        Deck.init();
        pobi = new Player("pobi");
        salbyul = new Player("salbyul");
        dealer = Dealer.getDealer();

        dealer.receiveCard(new Card(Shape.DIAMOND, 3));
        dealer.receiveCard(new Card(Shape.CLOVER, 9));
        dealer.receiveCard(new Card(Shape.DIAMOND, 8));
        pobi.receiveCard(new Card(Shape.HEART, 2));
        pobi.receiveCard(new Card(Shape.SPADE, 8));
        pobi.receiveCard(new Card(Shape.CLOVER, 1));
        salbyul.receiveCard(new Card(Shape.CLOVER, 7));
        salbyul.receiveCard(new Card(Shape.SPADE, 11));
    }

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
        Players players = new Players(Arrays.asList(new Player("coffee"), new Player("coco")));
        Player coffee = players.getPlayer("coffee");
        Player coco = players.getPlayer("coco");

        dealer.getCards().clear();
        Deck.giveTwoCards(players);

        assertThat(coffee.getCards()).size().isEqualTo(2);
        assertThat(coco.getCards()).size().isEqualTo(2);
        assertThat(dealer.getCards()).size().isEqualTo(2);
    }

    @Test
    @DisplayName("각 플레이어의 카드 합 결과 확인")
    void getResult() {
        assertThat(dealer.getResultValue()).isEqualTo(20);
        assertThat(pobi.getResultValue()).isEqualTo(21);
        assertThat(salbyul.getResultValue()).isEqualTo(17);
    }

    @Test
    void verifyResultAmount() {
        pobi.bet(10000);
        salbyul.bet(20000);

        Players players = new Players(Arrays.asList(pobi, salbyul));
        players.setPlayerIncome();

        assertThat(dealer.getIncome()).isEqualTo(10000);
        assertThat(pobi.getIncome()).isEqualTo(10000);
        assertThat(salbyul.getIncome()).isEqualTo(-20000);
    }

    public static void clearDealerCard() {
        Dealer.getDealer().getCards().clear();
    }
}
