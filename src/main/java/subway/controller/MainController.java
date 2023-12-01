package subway.controller;

import subway.domain.menu.Main;
import subway.exception.CustomIllegalArgumentException;
import subway.view.input.InputView;
import subway.view.output.OutputView;

public class MainController implements Controller {

    Main main;

    @Override
    public void run(final InputView inputView, final OutputView outputView) {
        do {
            selectMenu(inputView, outputView);
        } while (main.isRunning());
    }

    private void selectMenu(final InputView inputView, final OutputView outputView) {
        try {
            main = readMain(inputView);
            main.run(inputView, outputView);

        } catch (CustomIllegalArgumentException e) {
            main = Main.selectRouteState();
        }
    }

    private Main readMain(final InputView inputView) {
        return ExceptionHandler.getExceptionHandler(() -> {
            final String select = inputView.readMain();
            main = Main.findMenu(select);
            return main;
        });
    }
}
