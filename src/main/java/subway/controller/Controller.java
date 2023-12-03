package subway.controller;

import subway.view.input.InputView;
import subway.view.output.OutputView;

public interface Controller {

    void run(final InputView inputView, final OutputView outputView);
}
