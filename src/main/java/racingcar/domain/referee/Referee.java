package racingcar.domain.referee;

import racingcar.domain.car.Car;
import racingcar.domain.printer.Printer;

import java.util.List;
import java.util.stream.Collectors;

public class Referee {


    // 현재 상황을 중계함
    public void relayTheCurrentSituation(List<Car> racingCars) {
        racingCars.forEach(Car::print);
        Printer.printNextLine();
    }

    // 게임을 심판함
    public List<Car> ruledGame(List<Car> racingCars, int numberOfTimes) {
        Printer.printRunOfResult();
        for (int i = 0; i < numberOfTimes; i++) {
            racingCars.forEach(Car::move);
            this.relayTheCurrentSituation(racingCars);
        }

        int maxPosition = racingCars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElseThrow(IllegalArgumentException::new);

        return racingCars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .collect(Collectors.toList());
    }

}
