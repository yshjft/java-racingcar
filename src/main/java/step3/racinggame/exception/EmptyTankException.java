package step3.racinggame.exception;

public class EmptyTankException extends RuntimeException {

    public EmptyTankException() {
        super("연료가 떨어졌습니다.");
    }
}
