package racingcar.domain.car;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.printer.Printer;

public class Car {
    private final String name;
    private       int    position = 0;

    public Car(String name) {
        this.name = name;
    }
    // 추가 기능 구현

    // 앞으로 전진 혹은 정지
    public void move() {
        if (Randoms.pickNumberInRange(0, 9) >= 4) {
            this.position += 1;
        }
        Printer.progressDistanceOfCarMessage(this.name, this.position);
    }

    // 자동차 이동 결과
    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return this.position;
    }
}
