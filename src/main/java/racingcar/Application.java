package racingcar;

import racingcar.domain.game.RacingGame;
import racingcar.domain.player.Player;
import racingcar.domain.referee.Referee;
import racingcar.utils.input.InputImpl;
import racingcar.utils.randoms.RandomsImpl;

public class Application {
    public static void main(String[] args) {
        // TODO 구현 진행

        RacingGame game = new RacingGame(new Player( new InputImpl(), new RandomsImpl()), new Referee());
        game.play();
    }
}
