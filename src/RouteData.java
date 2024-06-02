import java.util.ArrayList;
import java.util.HashMap;

public class RouteData {
    private HashMap<String, ArrayList<String>> flightGraph;
  private HashMap<ArrayList<String>, Route> routes;

  public RouteData(HashMap<String, ArrayList<String>> flightGraph, HashMap<ArrayList<String>, Route> routes) {
    this.flightGraph = flightGraph;
    this.routes = routes;
  }

  public HashMap<String, ArrayList<String>> getFlightGraph() {
    return this.flightGraph;
  }

  public HashMap<ArrayList<String>, Route> getRoutes() {
    return this.routes;
  }
}
