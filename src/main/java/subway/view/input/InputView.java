package subway.view.input;

import java.util.Scanner;
import subway.view.input.validator.ReadValidator;
import subway.view.output.OutputView;

public class InputView {

    private final OutputView outputView;
    private final Scanner scanner;

    public InputView(final OutputView outputView, final Scanner scanner) {
        this.outputView = outputView;
        this.scanner = scanner;
    }

    public String readMain() {
        outputView.printReadMainMessage();
        return ReadValidator.validateRead(scanner.nextLine());
    }

    public String readRoute() {
        outputView.printReadRouteMessage();
        return ReadValidator.validateRead(scanner.nextLine());
    }

    public String readStartPoint() {
        outputView.printStartPointMessage();
        return ReadValidator.validateRead(scanner.nextLine());
    }

    public String readEndPoint() {
        outputView.printEndPointMessage();
        return ReadValidator.validateRead(scanner.nextLine());
    }
}
