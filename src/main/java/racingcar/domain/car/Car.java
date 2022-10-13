package racingcar.domain.car;


import racingcar.domain.printer.Printer;
import racingcar.utils.randoms.Randoms;
import racingcar.utils.randoms.RandomsFake;
import racingcar.utils.randoms.RandomsImpl;

public class Car {
    private String name;
    private int position = 0;
    private Randoms randoms;

    public Car(String name, Randoms randoms) {
        this.name = name;
        this.randoms =randoms;
    }

    public void move() {
        if (randoms.get() < 4) {
            return;
        }
        this.position++;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    public void print() {
        Printer.printCarNameAndCarPosition(name, position);

    }

    // 추가 기능 구현
}
