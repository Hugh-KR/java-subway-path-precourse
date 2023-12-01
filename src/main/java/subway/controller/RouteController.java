package subway.controller;

import subway.domain.menu.Main;
import subway.domain.menu.Route;
import subway.exception.CustomIllegalArgumentException;
import subway.view.input.InputView;
import subway.view.output.OutputView;

public class RouteController implements Controller {

    private static RouteFunction routeFunction;

    Route route;

    @Override
    public void run(final InputView inputView, final OutputView outputView) {
        do {
            try {
                routeFunction = new RouteFunction(inputView, outputView);
                route = readRoute(inputView, outputView);
                route.run();
            } catch (CustomIllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } while (route.isRunning());

    }


    private Route readRoute(final InputView inputView, final OutputView outputView) {
        return ExceptionHandler.getExceptionHandler(() -> {
            final String select = inputView.readRoute();
            route = Route.findMenu(select);
            return route;
        });
    }

    public static void shortestRoute() {
        routeFunction.shortestDistance();
    }

    public static void shortestTime() {
        routeFunction.shortestTime();
    }
}
