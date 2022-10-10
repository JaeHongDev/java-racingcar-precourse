package racingcar.domain.player;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.car.Car;
import racingcar.utils.NumericUtility;

import java.util.ArrayList;
import java.util.List;

public class Player {


    // 게임을 몇 번 진행 할 것인가
    public int requestNumberOfRuns() {
        String readValue = Console.readLine();
        // 변경된 숫자가 정수가 아닌경우
        if (!NumericUtility.isNumber(readValue)) {
            throw new IllegalArgumentException();
        }
        return Integer.parseInt(readValue);
    }

    // 경기에 참여할 자동차 생성 요청
    public List<Car> requestGenerateCar() {
        List<Car> cars = new ArrayList<>();

        for (String str : Console.readLine()
                                 .split(",")) {
            if (str.length() > 5) {
                throw new IllegalArgumentException();
            }
            cars.add(new Car(str));
        }
        return cars;
    }
}
