package racingcar.domain.game;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.car.Car;
import racingcar.domain.player.Player;
import racingcar.domain.printer.Printer;
import racingcar.domain.referee.Referee;

import java.util.List;

public class RacingGame {
    private Player player;
    private Referee referee;

    public RacingGame(Player player, Referee referee) {
        this.player = player;
        this.referee = referee;
    }

    public void play() {
        Printer.printWinner(referee.ruledGame(
                player.generateRacingCars(),
                player.generateNumberOfTimes()
        ));
    }
}
