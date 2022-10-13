package racingcar.utils.randoms;

public class RandomsFake implements Randoms{
    public Integer[] numbers;
    public Integer index = 0;
    public RandomsFake(Integer[] numbers){
        this.numbers = numbers;
    }
    @Override
    public Integer get() {
        return this.numbers[this.index++];
    }
}
