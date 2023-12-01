package subway;

import java.util.Scanner;
import subway.controller.MainController;
import subway.controller.RouteController;
import subway.view.input.InputView;
import subway.view.output.OutputView;

public class AppConfig {

    public final MainController mainController;
    public final InputView inputView;
    public final OutputView outputView;
    public final Scanner scanner;

    public AppConfig(final Scanner scanner) {
        this.scanner = scanner;
        this.outputView = initOutputView();
        this.inputView = initInputView(outputView, scanner);
        this.mainController = initMainController();
    }

    private OutputView initOutputView() {
        return new OutputView();
    }

    private InputView initInputView(final OutputView outputView, final Scanner scanner) {
        return new InputView(outputView, scanner);
    }

    private MainController initMainController() {
        return new MainController();
    }
}
