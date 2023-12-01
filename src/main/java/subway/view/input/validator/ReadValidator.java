package subway.view.input.validator;

import subway.exception.CustomIllegalArgumentException;
import subway.exception.menu.MenuExceptionStatus;

public class ReadValidator {

    static final ReadValidator READ_MENU_VALIDATOR = new ReadValidator();

    private ReadValidator() {
    }

    public static String validateRead(final String select) {
        return READ_MENU_VALIDATOR.isNull(select);
    }

    private String isNull(final String select) {
        try {
            return select.trim();
        } catch (NullPointerException e) {
            throw new CustomIllegalArgumentException(MenuExceptionStatus.MENU_IS_INVALID);
        }
    }
}
