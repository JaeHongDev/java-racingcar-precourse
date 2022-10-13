package racingcar.domain.printer;

import racingcar.domain.car.Car;

import java.util.List;

public class Printer {

    public static void printRequestCarName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public static void printRequestNumberOfTimes() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public static void printRunOfResult() {
        System.out.println("실행 결과");
    }

    public static void printWinner(List<Car> winners) {
        System.out.print("최종 우승자 : ");
        for (int i = 0; i < winners.size(); i++) {
            System.out.print(winners.get(i).getName());
            if (i != winners.size() - 1) {
                System.out.print(", ");
            }
        }
    }

    public static void printCarNameAndCarPosition(String name, int position) {
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0 ; i < position; i++){
            stringBuilder.append("-");
        }
        System.out.println(name + " : " + stringBuilder.toString());
    }

    public static void printNextLine() {
        System.out.println();
    }
}
