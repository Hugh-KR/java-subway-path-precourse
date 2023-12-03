package subway.domain.subway.line;

import java.util.LinkedList;
import java.util.List;

public class Line {
    private final String name;
    private final List<String> stations = new LinkedList<>();

    public Line(final String name, final List<String> graphData) {
        this.name = name;
        stations.addAll(graphData);
    }

    public static Line from(final String name, final List<String> stations) {
        return new Line(name, stations);
    }

    public boolean contains(final String station) {
        return stations.contains(station);
    }

    public boolean validSequence(final String startPoint, final String endPoint) {
        return stations.indexOf(startPoint) < stations.indexOf(endPoint);
    }

    public String getName() {
        return name;
    }
}
