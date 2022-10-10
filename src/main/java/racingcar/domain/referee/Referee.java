package racingcar.domain.referee;

import racingcar.domain.car.Car;
import racingcar.domain.player.Player;
import racingcar.domain.printer.Printer;

import java.util.ArrayList;
import java.util.List;

public class Referee {

    // 게임을 판정합니다.
    public void ruledGame(Player player) {
        List<Car> generatedCars = player.requestGenerateCar();
        int       numbersOfRun  = player.requestNumberOfRuns();

        Printer.resultMessage();
        // 경기를 진행
        for (int i = 0; i < numbersOfRun; i++) {
            // 자동차들은 움직임
            for (Car car : generatedCars) {
                car.move();
                Printer.progressDistanceOfCarMessage(car.getName(), car.getPosition());
            }
        }

        List<String> winners = new ArrayList<>();
        // 최대 거리
        int max = Integer.MIN_VALUE;
        // 최대로 이동한 사람들을 저장해야죠
        for (Car car : generatedCars) {
            if (car.getPosition() > max) {
                max = car.getPosition();
                winners.clear();
                winners.add(car.getName());
                continue;
            }
            if (car.getPosition() == max) {
                winners.add(car.getName());
            }
        }
        Printer.winnerMessage(winners);
    }
}
