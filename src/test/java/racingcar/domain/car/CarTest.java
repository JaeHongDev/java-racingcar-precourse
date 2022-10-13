package racingcar.domain.car;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import racingcar.utils.randoms.RandomsFake;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    private Car car;

    public void initializeCar(String name, Integer[] numbers){
        this.car = new Car(name, new RandomsFake(numbers));
    }

    private void initializeCar(String name){
        this.initializeCar(name, new Integer[]{});
    }


    @AfterEach
    public void teardown(){
        this.car = null;
    }
    @Test
    public void 생성자를_통해서_이름을_부여받는다() {
        this.initializeCar("자동차");
        assertThat(this.car.getName()).isEqualTo("자동차");
        assertThat(this.car.getPosition()).isEqualTo(0);
    }
    @Test
    public void 자동차는_4가_넘는_값이_입력되면_position의_값이_1늘어난다() {
        this.initializeCar("자동차", new Integer[]{1,2,3,4});
        for(int i = 0 ; i < 4;i++){
            this.car.move();
        }

        assertThat(this.car.getPosition()).isEqualTo(1);
    }

}