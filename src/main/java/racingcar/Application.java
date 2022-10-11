package racingcar;

import racingcar.domain.game.RacingGame;
import racingcar.domain.player.Player;
import racingcar.domain.referee.Referee;

public class Application {
    public static void main(String[] args) {
        // TODO 구현 진행


        RacingGame game = new RacingGame(new Player(), new Referee());
        game.play();
    }
}
