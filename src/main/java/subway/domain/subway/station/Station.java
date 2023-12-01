package subway.domain.subway.station;

public class Station {
    private String name;

    public Station(String name) {
        this.name = name;
    }

    public static Station from(String name) {
        return new Station(name);
    }

    public String getName() {
        return name;
    }
}
