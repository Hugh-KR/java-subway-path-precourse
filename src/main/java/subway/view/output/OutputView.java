package subway.view.output;

import java.util.List;
import subway.view.output.message.OutputMessage;

public class OutputView {

    public void printMessage(final String message) {
        System.out.println(message);
    }

    private void printMessage(final OutputMessage outputMessage) {
        this.printMessage(outputMessage.getMessage());
    }

    public void printReadMainMessage() {
        printEmptyLine();
        printMessage(OutputMessage.READ_SELECT_MAIN_MESSAGE);
    }

    public void printReadRouteMessage() {
        printEmptyLine();
        printMessage(OutputMessage.READ_SELECT_ROUTE_MESSAGE);
    }

    public void printExitMessage() {
        printMessage(OutputMessage.PRINT_EXIT_MESSAGE);
    }

    public void printStartPointMessage() {
        printEmptyLine();
        printMessage(OutputMessage.READ_SELECT_START_STATION_MESSAGE);
    }

    public void printEndPointMessage() {
        printEmptyLine();
        printMessage(OutputMessage.READ_SELECT_END_STATION_MESSAGE);
    }

    public void printResultMessage(final int distance, final int time, final List<String> paths) {
        printMessage(String.format(OutputMessage.PRINT_RESULT_ROUTE_MESSAGE.getMessage(), distance, time));
        paths.forEach(path -> printMessage(
                String.format(OutputMessage.PRINT_INFO_MESSAGE.getMessage(), path)
        ));
    }

    public void printEmptyLine() {
        System.out.println();
    }
}
