package racingcar.domain.player;

import net.bytebuddy.implementation.bytecode.Throw;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.Car;
import racingcar.utils.input.InputFake;
import racingcar.utils.randoms.RandomsFake;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

public class PlayerTest {
    private Player player;

    public void initialize(String carNames) {
        this.player = new Player(new InputFake(carNames), new RandomsFake(new Integer[]{1}));
    }

    @AfterEach
    public void teardown() {
        this.player = null;
    }

    @Test
    public void 자동차의_이름을_콤마로_구분해서_입력을_받아서_리스트로_만든다() {
        this.initialize("자동차,자동1");
        List<Car> cars = this.player.generateRacingCars();

        Assertions.assertThat(cars.get(0).getName()).isEqualTo("자동차");
        Assertions.assertThat(cars.get(1).getName()).isEqualTo("자동1");
    }

    @Test
    public void 자동차의_이름을_콤마로_구분했을때_글자가_5자리가_넘어가면_오류를_발생시킨다() {
        this.initialize("자동차자동차");
        assertThatThrownBy(() -> {
            this.player.generateRacingCars();
        }).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("[ERROR]");
    }

    @Test
    public void 몇번_실행할지_요청을_받아오는_그_숫자를_검증한다() {
        this.initialize("1");
        int numberOfTimes = this.player.generateNumberOfTimes();
        assertThat(numberOfTimes).isEqualTo(1);
    }

    @Test
    public void 사용자로부터_입력을_받는다면_숫자가_아닌_모든_값은_에러를_발생시킨다() {
        this.initialize("a1");
        assertThatThrownBy(() -> {
            this.player.generateNumberOfTimes();
        }).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("[ERROR]");
    }
}