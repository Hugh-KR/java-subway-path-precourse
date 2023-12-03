package subway.domain.menu;

import java.util.Arrays;
import java.util.Objects;
import subway.controller.Controller;
import subway.controller.RouteController;
import subway.exception.CustomIllegalArgumentException;
import subway.exception.menu.MenuExceptionStatus;
import subway.view.input.InputView;
import subway.view.output.OutputView;

public enum Main {

    SHOW_ROUTE("1", new RouteController()),
    EXIT("Q", null);

    private final String select;
    private final Controller controller ;

    Main(final String select, final Controller controller) {
        this.select = select;
        this.controller = controller;
    }

    public static Main selectRouteState() {
        return Main.SHOW_ROUTE;
    }

    public static Main findMenu(final String select) {
        return Arrays.stream(Main.values())
                .filter(menu -> Objects.equals(menu.select, select))
                .findAny()
                .orElseThrow(() -> new CustomIllegalArgumentException(MenuExceptionStatus.MENU_IS_INVALID));
    }

    public void run(final InputView inputView, final OutputView outputView) {
        if (isRunning()) {
            controller.run(inputView, outputView);
        }
    }

    public boolean isRunning() {
        return !Objects.equals(Main.EXIT, this);
    }
}
