package racingcar.utils.input;

import camp.nextstep.edu.missionutils.Console;

public class InputImpl implements Inputs{

    @Override
    public String get() {
        return Console.readLine();
    }
}
