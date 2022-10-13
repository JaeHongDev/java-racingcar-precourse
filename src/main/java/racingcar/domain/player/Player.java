package racingcar.domain.player;

import racingcar.domain.car.Car;
import racingcar.utils.input.Inputs;
import racingcar.utils.randoms.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private final Inputs inputs;
    private final Randoms randoms;

    public Player(Inputs inputs, Randoms randoms) {
        this.inputs = inputs;
        this.randoms = randoms;
    }

    public List<Car> generateRacingCars() {
        try {
            return this.validateCarsName(inputs.get());
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            return this.generateRacingCars();
        }
    }

    private List<Car> validateCarsName(String carNames) {
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames.split(",")) {
            if (carName.length() > 5) {
                throw new IllegalArgumentException("[ERROR] 자동차의 이름이 5자리를 넘어갔습니다.");
            }
            cars.add(new Car(carName, randoms));
        }
        return cars;
    }

    public int generateNumberOfTimes() {
        try {
            return validateNumberOfTimes();
        }catch (IllegalArgumentException exception){
            System.out.println(exception.getMessage());
            return this.generateNumberOfTimes();
        }
    }

    private int validateNumberOfTimes() {
        String numberOfTimesStr = this.inputs.get();
        try {
            return Integer.parseInt(numberOfTimesStr);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException("[ERROR] 숫자가 아닌 다른 값이 입력 되었습니다.");
        }
    }
}
