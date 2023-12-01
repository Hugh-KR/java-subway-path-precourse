package subway;

import java.util.Scanner;
import subway.controller.MainController;
import subway.domain.subway.saction.SectionData;

public class Application {

    private final AppConfig appConfig;
    private final MainController mainController;

    public Application(final Scanner scanner) {
        appConfig = new AppConfig(scanner);
        this.mainController = appConfig.mainController;
    }

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        Application application = new Application(scanner);
        application.run();
    }

    public void run() {
        SectionData.load();
        mainController.run(appConfig.inputView, appConfig.outputView);
    }
}
