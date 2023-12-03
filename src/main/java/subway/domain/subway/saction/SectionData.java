package subway.domain.subway.saction;

import java.util.Arrays;
import java.util.List;
import subway.domain.subway.line.Line;
import subway.domain.subway.line.LineRepository;
import subway.domain.subway.station.Station;
import subway.domain.subway.station.StationRepository;

public class SectionData {

    private static final SectionData SECTION_DATA = new SectionData();

    public static void load() {
        SECTION_DATA.stationLoad();
        SECTION_DATA.lineLoad();
        SECTION_DATA.subwayLoad();
    }

    private void stationLoad() {
        StationRepository.addStation(Station.from("교대역"));
        StationRepository.addStation(Station.from("강남역"));
        StationRepository.addStation(Station.from("역삼역"));
        StationRepository.addStation(Station.from("남부터미널역"));
        StationRepository.addStation(Station.from("양재역"));
        StationRepository.addStation(Station.from("양재시민의숲역"));
        StationRepository.addStation(Station.from("매봉역"));
    }

    private void lineLoad() {
        LineRepository.addLine(Line.from("2호선", Arrays.asList("교대역", "강남역", "역삼역")));
        LineRepository.addLine(Line.from("3호선", Arrays.asList("교대역", "남부터미널역", "양재역", "매봉역")));
        LineRepository.addLine(Line.from("신분당선", Arrays.asList("강남역", "양재역", "양재시민의숲역")));
    }

    private void subwayLoad() {
        SectionRepository.initStations(StationRepository.stations());
        SectionRepository.addEdgeGraphs(List.of("교대역", "강남역"), 2, 3);
        SectionRepository.addEdgeGraphs(List.of("강남역", "역삼역"), 2, 3);
        SectionRepository.addEdgeGraphs(List.of("교대역", "남부터미널역"), 3, 2);
        SectionRepository.addEdgeGraphs(List.of("남부터미널역", "양재역"), 6, 5);
        SectionRepository.addEdgeGraphs(List.of("양재역", "매봉역"), 1, 1);
        SectionRepository.addEdgeGraphs(List.of("강남역", "양재역"), 2, 8);
        SectionRepository.addEdgeGraphs(List.of("양재역", "양재시민의숲역"), 10, 3);
    }
}
