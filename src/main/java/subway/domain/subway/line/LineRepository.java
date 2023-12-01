package subway.domain.subway.line;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import subway.exception.CustomIllegalArgumentException;
import subway.exception.station.StationExceptionStatus;

public class LineRepository {

    private static final List<Line> lines = new ArrayList<>();

    public static List<Line> lines() {
        return Collections.unmodifiableList(lines);
    }

    public static void addLine(Line line) {
        lines.add(line);
    }

    public static boolean deleteLineByName(String name) {
        return lines.removeIf(line -> Objects.equals(line.getName(), name));
    }

    public static void deleteAll() {
        lines.clear();
    }

    private static Optional<Line> findLine(final String startPoint, final String endPoint) {
        return lines.stream()
                .filter(line -> line.contains(startPoint) && line.contains(endPoint))
                .findAny();
    }

    public static void isSameLine(final String startPoint, final String endPoint) {
        findLine(startPoint, endPoint)
                .orElseThrow(() ->
                        new CustomIllegalArgumentException(StationExceptionStatus.STATION_IS_NOT_SAME_LINE));
    }

    public static void invalidSequence(final String startPoint, final String endPoint) {
        lines.stream()
                .filter(line ->
                        line.contains(startPoint)
                                && line.contains(endPoint)
                                        && line.validSequence(startPoint, endPoint))
                .findAny()
                .orElseThrow(() ->
                        new CustomIllegalArgumentException(StationExceptionStatus.STATION_IS_INVALID_SEQUENCE));
    }
}
