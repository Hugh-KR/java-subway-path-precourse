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
        try {
            routeFunction = new RouteFunction(inputView, outputView);
            route = readRoute(inputView);
            route.run();
        } catch (CustomIllegalArgumentException e) {
            System.out.println(e.getMessage());
            run(inputView, outputView);
        }
    }

    private Route readRoute(final InputView inputView) {
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
