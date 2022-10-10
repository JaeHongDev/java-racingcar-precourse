package racingcar.domain.printer;

import racingcar.domain.car.Car;
import racingcar.utils.StringUtility;

import java.util.List;

public class Printer {

    // 게임 시작 메시지 출력
    public static void gameStartMessage() {
        System.out.println(Message.REQUEST_NAME);
    }

    // 게임 시도 횟수 요청 출력
    public static void requestNumberOfRunMessage() {
        System.out.println(Message.REQUEST_NUMBER_OF_RUN);
    }

    // 게임 결과 메시지 출력
    public static void resultMessage() {
        System.out.println(Message.RESULT);
    }

    // 자동차 이동 거리 진행상황 출력
    public static void progressDistanceOfCarMessage(String name, int position) {
        System.out.println(name + ":" + StringUtility.repeatString("-", position));
    }

    // 최종 우승자 메시지 출력
    public static void winnerMessage(List<String> winners) {
        for (int i = 0; i < winners.size(); i++) {
            System.out.print(winners.get(i));
            if (i < winners.size() - 1) {
                System.out.print(", ");
            }
        }
    }


}
