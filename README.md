# 미션 - 자동차 경주 게임

## 구현 목록

- 게임 도메인
  - [ ] 게임 시작 메서드 생성
  - [ ] 생성자를 통해서 게임을 시작하기 위해 필요한 의존성 주입 받기 ( 프린터, 심판, 플레이어) 
- 심판 도메인
  - [ ] 심판은 플레이어에게 참여할 자동차 목록을 만들도록 요청하여 해당 목록을 응답 받습니다.
  - [ ] 심판은 플레이어에게 게임을 몇번 진행할 것인지 요청하여 결과값을 응답 받습니다.
  - [ ] 심판은 플레이어에게 받아온 정보를 토대로 게임을 진행 시킵니다.
  - [ ] 게임을 진행 시키면서 결과 값을 게임 프린터에게 출력을 요청하며 응답은 받지 않습니다. (ONLY 출력)
  - [ ] 자동차 명단을 확인 한 후 게임 우승자를 판단 하고 게임 프린터에 결과를 요청합니다 (ONLY 출력)[요구사항 #6]
  - [ ] 우승자가 여러명인 경우 쉼표를 기준으로 구분하여 게임 프린터에 결과를 요청함(ONLY 출력)[요구사항 #7]
- 플레이어 도메인
  - [ ] 게임에 참여할 자동차를 생성합니다.
  - [ ] 게임을 몇 번 진행할 것인지 정합니다. [요구사항 #4]
  - [ ] 게임에 참여하는 자동차의 이름이 5자가 넘지 않도록 확인합니다. [요구사항 #3]
  - [ ] 잘못된 값을 입력하는 경우 IllegalArgumentException을 발생시키고 게임 프린터에게 해당 정보를 넘긴 이후 메시지를 출력합니다 [요구하상 #8]
- 자동차 도메인
  - [X] 자동차는 생성자를 통해서 자동차의 이름을 주입받습니다.[요구사항 #2]
  - [X] 자동차는 자신 스스로 출력에 대한 정보를 제공합니다. [요구사항 #2]
  - [X] 자동차는 랜덤한 값(0 ~ 9 사이에서 4 이상의 경우 전진)에 따라 한 칸 이동 하거나 멈춥니다 [요구사항 #5,#1]
- 프린터 도메인
  - [X] 게임 출력에 필요한 상수값 정의 및 출력 메서드 생성
    - [X] 에러 메시지 
    - [X] 실행 결과 
    - [X] 시작 메시지 
    - [X] 게임 진행 수 요청 메시지 
    - [X] 우승자 메시지
    - [X] 실행 결과 메시지
## 🔍 진행방식

- 미션은 **기능 요구사항, 프로그래밍 요구사항, 과제 진행 요구사항** 세 가지로 구성되어 있다.
- 세 개의 요구사항을 만족하기 위해 노력한다. 특히 기능을 구현하기 전에 기능 목록을 만들고, 기능 단위로 커밋 하는 방식으로 진행한다.

## ✉️ 미션 제출 방법

- 미션 구현을 완료한 후 GitHub을 통해 제출해야 한다.
  - GitHub을 활용한 제출 방법은 [프리코스 과제 제출 문서](https://github.com/woowacourse/woowacourse-docs/tree/master/precourse) 를 참고해 제출한다.
- GitHub에 미션을 제출한 후 [우아한테크코스 지원 플랫폼](https://apply.techcourse.co.kr) 에 접속하여 프리코스 과제를 제출한다.
  - 자세한 방법은 [링크](https://github.com/woowacourse/woowacourse-docs/tree/master/precourse#제출-가이드) 를 참고한다.
  - **Pull Request만 보내고, 지원 플랫폼에서 과제를 제출하지 않으면 최종 제출하지 않은 것으로 처리되니 주의한다.**

## ✔️ 과제 제출 전 체크리스트 - 0점 방지

- 터미널에서 `java -version`을 실행해 자바 8인지 확인한다. 또는 Eclipse, IntelliJ IDEA와 같은 IDE의 자바 8로 실행하는지 확인한다.
- 터미널에서 맥 또는 리눅스 사용자의 경우 `./gradlew clean test`, 윈도우 사용자의 경우 `gradlew.bat clean test` 명령을 실행했을 때 모든 테스트가 아래와 같이 통과하는지 확인한다.

```
BUILD SUCCESSFUL in 0s
```

---

## 🚀 기능 요구사항

초간단 자동차 경주 게임을 구현한다.

- [1]주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
- [2]각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
- [3]자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
- [4]사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
- [5]전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.
- [6]자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.
- [7]우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다.
- [8]사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`를 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.
- [9]아래의 프로그래밍 실행 결과 예시와 동일하게 입력과 출력이 이루어져야 한다.

<br>

## ✍🏻 입출력 요구사항

### ⌨️ 입력

- 경주 할 자동차 이름(이름은 쉼표(,) 기준으로 구분)

```
pobi,woni,jun
```

- 시도할 회수

```
5
```

### 🖥 출력

- 각 차수별 실행 결과

```
pobi : --
woni : ----
jun : ---
```

- 단독 우승자 안내 문구

```
최종 우승자 : pobi
```

- 공동 우승자 안내 문구

```
최종 우승자 : pobi, jun
```

- 예외 상황 시 에러 문구를 출력해야 한다. 단, 에러 문구는 [ERROR] 로 시작해야 한다.

```
[ERROR] 시도 횟수는 숫자여야 한다.
```

### 💻 프로그래밍 실행 결과 예시

```
경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)
pobi,woni,jun
시도할 회수는 몇회인가요?
5

실행 결과
pobi : -
woni : 
jun : -

pobi : --
woni : -
jun : --

pobi : ---
woni : --
jun : ---

pobi : ----
woni : ---
jun : ----

pobi : -----
woni : ----
jun : -----

최종 우승자 : pobi, jun
```

<br>

## 🎱 프로그래밍 요구사항

- 프로그램을 실행하는 시작점은 `Application`의 `main()`이다.
- JDK 8 버전에서 실행 가능해야 한다. **JDK 8에서 정상 동작하지 않을 경우 0점 처리**한다.
- 자바 코드 컨벤션을 지키면서 프로그래밍한다.
   - https://naver.github.io/hackday-conventions-java
- indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다. 2까지만 허용한다.
   - 예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다.
   - 힌트: indent(인덴트, 들여쓰기) depth를 줄이는 좋은 방법은 함수(또는 메소드)를 분리하면 된다.
- 3항 연산자를 쓰지 않는다.
- 함수(또는 메소드)가 한 가지 일만 하도록 최대한 작게 만들어라.
- 프로그래밍 요구사항에서 별도로 변경 불가 안내가 없는 경우 파일 수정과 패키지 이동을 자유롭게 할 수 있다.

### 추가된 요구사항

- 함수(또는 메소드)의 길이가 15라인을 넘어가지 않도록 구현한다.
   - 함수(또는 메소드)가 한 가지 일만 잘 하도록 구현한다.
- else 예약어를 쓰지 않는다.
   - 힌트: if 조건절에서 값을 return하는 방식으로 구현하면 else를 사용하지 않아도 된다.
   - else를 쓰지 말라고 하니 switch/case로 구현하는 경우가 있는데 switch/case도 허용하지 않는다.

### 프로그래밍 요구사항 - Car 객체

- 다음 Car 객체를 활용해 구현해야 한다.
- Car 기본 생성자를 추가할 수 없다.
- name, position 변수의 접근 제어자인 private을 변경할 수 없다.
- 가능하면 setPosition(int position) 메소드를 추가하지 않고 구현한다.

```java
public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    // 추가 기능 구현
}
```

### 프로그래밍 요구사항 - Randoms, Console

- JDK에서 기본 제공하는 Random, Scanner API 대신 `camp.nextstep.edu.missionutils`에서 제공하는 `Randoms`, `Console` API를 활용해 구현해야 한다.
   - Random 값 추출은 `camp.nextstep.edu.missionutils.Randoms`의 `pickNumberInRange()`를 활용한다.
   - 사용자가 입력하는 값은 `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용한다.
- 프로그램 구현을 완료했을 때 `src/test/java` 디렉터리의 `ApplicationTest`에 있는 모든 테스트 케이스가 성공해야 한다. **테스트가 실패할 경우 0점 처리한다.**

<br>

---

## 📈 과제 진행 요구사항

- 미션은 [java-racingcar-precourse](https://github.com/woowacourse/java-racingcar-precourse) 저장소를 Fork/Clone해 시작한다.
- **기능을 구현하기 전에 java-racingcar-precourse/docs/README.md 파일에 구현할 기능 목록을 정리**해 추가한다.
- **Git의 커밋 단위는 앞 단계에서 README.md 파일에 정리한 기능 목록 단위**로 추가한다.
   - [AngularJS Commit Message Conventions](https://gist.github.com/stephenparish/9941e89d80e2bc58a153) 참고해 commit log를 남긴다.
- 과제 진행 및 제출 방법은 [프리코스 과제 제출 문서](https://github.com/woowacourse/woowacourse-docs/tree/master/precourse) 를 참고한다.

<br>

---

## 📝 License

This project is [MIT](https://github.com/woowacourse/java-racingcar-precourse/blob/master/LICENSE) licensed.
