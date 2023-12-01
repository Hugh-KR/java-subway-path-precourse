package subway.exception.menu;

import subway.exception.ExceptionStatus;

public enum MenuExceptionStatus implements ExceptionStatus {

    MENU_IS_INVALID("잘못된 입력입니다.");

    private static final String MESSAGE_PREFIX = "\n[ERROR] ";

    private final String message;

    MenuExceptionStatus(final String message) {
        this.message = MESSAGE_PREFIX + message;
    }

    public String getMessage() {
        return this.message;
    }
}
