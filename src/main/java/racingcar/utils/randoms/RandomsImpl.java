package racingcar.utils.randoms;

public class RandomsImpl implements Randoms {

    @Override
    public Integer get() {
        return camp.nextstep.edu.missionutils.Randoms.pickNumberInRange(1, 9);
    }
}
