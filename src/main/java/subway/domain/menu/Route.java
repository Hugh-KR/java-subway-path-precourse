package subway.domain.menu;

import java.util.Arrays;
import java.util.Objects;
import subway.controller.RouteController;
import subway.exception.CustomIllegalArgumentException;
import subway.exception.menu.MenuExceptionStatus;

public enum Route {

    SHORTEST_DISTANCE("1", RouteController::shortestRoute),
    SHORTEST_TIME("2", RouteController::shortestTime),
    BACK("B", null);

    private final String select;
    private final Runnable runnable;

    Route(final String select, final Runnable runnable) {
        this.select = select;
        this.runnable = runnable;
    }

    public static Route findMenu(final String select) {
        return Arrays.stream(Route.values())
                .filter(menu -> Objects.equals(menu.select, select))
                .findAny()
                .orElseThrow(() -> new CustomIllegalArgumentException(MenuExceptionStatus.MENU_IS_INVALID));
    }

    public void run() {
        if (isRunning()) {
            runnable.run();
        }
    }

    public boolean isRunning() {
        return !Objects.equals(Route.BACK, this);
    }
}
