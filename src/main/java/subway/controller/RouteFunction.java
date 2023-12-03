package subway.controller;


import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import subway.domain.subway.saction.SectionRepository;
import subway.domain.subway.line.LineRepository;
import subway.domain.subway.station.StationRepository;
import subway.exception.CustomIllegalArgumentException;
import subway.exception.station.StationExceptionStatus;
import subway.view.input.InputView;
import subway.view.output.OutputView;

public class RouteFunction {

    private final InputView inputView;
    private final OutputView outputView;

    public RouteFunction(final InputView inputView,
                         final OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void shortestDistance() {
        final List<String> readStations = readStation();
        final int route = SectionRepository.findShortestRoute(readStations);
        final List<String> paths = SectionRepository.findShortestRouteOfPath(readStations);
        final int time = SectionRepository.findShortestRouteOfTime(paths);
        outputView.printResultMessage(route, time, paths);
    }

    public void shortestTime() {
        final List<String> readStations = readStation();
        final int time = SectionRepository.findShortestTime(readStations);
        final List<String> paths = SectionRepository.findShortestTimeOfPath(readStations);
        final int route = SectionRepository.findShortestTimeOfRoute(paths);
        outputView.printResultMessage(route, time, paths);
    }

    private List<String> readStation() {
        final String startPoint = readStartPoint();
        final String endPoint = readEndPoint();
        isSameStation(startPoint, endPoint);
        isValidLine(startPoint, endPoint);
        return Arrays.asList(startPoint, endPoint);
    }

    private void isValidLine(final String startPoint, final String endPoint) {
        LineRepository.isSameLine(startPoint, endPoint);
        LineRepository.invalidSequence(startPoint, endPoint);
    }

    private void isSameStation(final String startPoint, final String endPoint) {
        if (Objects.equals(startPoint, endPoint)) {
            throw new CustomIllegalArgumentException(StationExceptionStatus.STATION_IS_DUPLICATED);
        }
    }

    private String readStartPoint() {
        final String startPoint = inputView.readStartPoint();
        StationRepository.isExist(startPoint);
        return startPoint;
    }

    private String readEndPoint() {
        final String endPoint = inputView.readEndPoint();
        StationRepository.isExist(endPoint);
        return endPoint;
    }
}
