import java.util.ArrayList;
import java.util.HashMap;

/**
 * The RouteData class represents the data structure that holds the flight graph and routes information.
 */
public class RouteData {
  private HashMap<String, ArrayList<String>> flightGraph;
  private HashMap<ArrayList<String>, Route> routes;

  /**
   * Constructs a new RouteData object with the specified flight graph and routes.
   *
   * @param flightGraph the flight graph, represented as a HashMap of airport codes to a list of destination airport codes
   * @param routes the routes, represented as a HashMap of a list of airport codes to a Route object
   */
  public RouteData(HashMap<String, ArrayList<String>> flightGraph, HashMap<ArrayList<String>, Route> routes) {
    this.flightGraph = flightGraph;
    this.routes = routes;
  }

  /**
   * Returns the flight graph.
   *
   * @return the flight graph, represented as a HashMap of airport codes to a list of destination airport codes
   */
  public HashMap<String, ArrayList<String>> getFlightGraph() {
    return this.flightGraph;
  }

  /**
   * Returns the routes.
   *
   * @return the routes, represented as a HashMap of a list of airport codes to a Route object
   */
  public HashMap<ArrayList<String>, Route> getRoutes() {
    return this.routes;
  }
}
