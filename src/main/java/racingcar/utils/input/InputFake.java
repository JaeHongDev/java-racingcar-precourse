package racingcar.utils.input;

public class InputFake implements Inputs{

    private String str;
    public InputFake(String str){
       this.str = str;
    }
    @Override
    public String get() {
        return this.str;
    }
}
