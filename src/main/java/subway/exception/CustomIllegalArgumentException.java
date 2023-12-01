package subway.exception;

public class CustomIllegalArgumentException extends IllegalArgumentException {

    public CustomIllegalArgumentException(final ExceptionStatus exceptionStatus) {
        super(exceptionStatus.getMessage());
    }
}
