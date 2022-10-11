package racingcar.domain.game;

import racingcar.domain.player.Player;
import racingcar.domain.printer.Printer;
import racingcar.domain.referee.Referee;

// 자동차 경주 게임을 진행하기 위한 게임 클래스
public class RacingGame {

    private final Player  player;
    private final Referee referee;

    public RacingGame(Player player, Referee referee) {
        this.player  = player;
        this.referee = referee;
    }

    // 자동차 경주 게임은 해당 메서드를 통해서 게임이 시작됨
    public void play() {
        Printer.gameStartMessage();
        Printer.winnerMessage(referee.ruledGame(this.player));
    }
}
