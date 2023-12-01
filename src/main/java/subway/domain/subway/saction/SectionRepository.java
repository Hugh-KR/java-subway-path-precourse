package subway.domain.subway.saction;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;
import subway.domain.subway.station.Station;

public class SectionRepository {

    private static final WeightedMultigraph<String, DefaultWeightedEdge> timeGraph
            = new WeightedMultigraph(DefaultWeightedEdge.class);
    private static final WeightedMultigraph<String, DefaultWeightedEdge> routeGraph
            = new WeightedMultigraph(DefaultWeightedEdge.class);
    private static final Map<List<String>, Integer> timeEdge = new HashMap<>();
    private static final Map<List<String>, Integer> routeEdge = new HashMap<>();

    public static void initStations(final List<Station> stations) {
        stations.forEach(station -> routeGraph.addVertex(station.getName()));
        stations.forEach(station -> timeGraph.addVertex(station.getName()));
    }

    public static void addEdgeGraphs(final List<String> stations, final int route, final int time) {
        final String startPoint = stations.get(0);
        final String endPoint = stations.get(1);
        routeGraph.setEdgeWeight(routeGraph.addEdge(startPoint, endPoint), route);
        timeGraph.setEdgeWeight(timeGraph.addEdge(startPoint, endPoint), time);
        timeEdge.put(stations, time);
        routeEdge.put(stations, route);
    }

    public static int findShortestRoute(final List<String> stations) {
        final String startPoint = stations.get(0);
        final String endPoint = stations.get(1);
        final DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(routeGraph);
        return (int)dijkstraShortestPath.getPathWeight(startPoint, endPoint);
    }

    public static List<String> findShortestRouteOfPath(final List<String> stations) {
        final String startPoint = stations.get(0);
        final String endPoint = stations.get(1);
        final DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(routeGraph);
        return dijkstraShortestPath.getPath(startPoint, endPoint).getVertexList();
    }

    public static int findShortestRouteOfTime(final List<String> paths) {
        int time = 0;
        for (int i = 0; i < paths.size() - 1; i++) {
            String startPoint = paths.get(i);
            String endPoint = paths.get(i + 1);
            time += timeEdge.get(Arrays.asList(startPoint, endPoint));
        }
        return time;
    }

    public static int findShortestTime(final List<String> stations) {
        final String startPoint = stations.get(0);
        final String endPoint = stations.get(1);
        DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(timeGraph);
        return  (int)dijkstraShortestPath.getPathWeight(startPoint, endPoint);
    }

    public static List<String> findShortestTimeOfPath(final List<String> stations) {
        final String startPoint = stations.get(0);
        final String endPoint = stations.get(1);
        DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(timeGraph);
        return dijkstraShortestPath.getPath(startPoint, endPoint).getVertexList();
    }

    public static int findShortestTimeOfRoute(final List<String> paths) {
        int route = 0;
        for (int i = 0; i < paths.size() - 1; i++) {
            String firstStation = paths.get(i);
            String lastStation = paths.get(i + 1);
            route += timeEdge.get(Arrays.asList(firstStation, lastStation));
        }
        return route;
    }
}
