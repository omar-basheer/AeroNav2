import java.util.ArrayList;
import java.util.HashMap;

public class Main {

    @SuppressWarnings("unused")
    public static void main(String[] args) {

    HashMap<ArrayList<String>, Airport> airports = CsvParser.parseAirports("files/airports.csv");
    // CsvParser.printAirports(airports);

    HashMap<String, Airline> airlines = CsvParser.parseAirlines("files/airlines.csv");
    // CsvParser.printAirlines(airlines);

    RouteData routeData = CsvParser.parseRoutes("files/routes.csv");
    // CsvParser.printRoutes(routeData);
    // CsvParser.printFlightGraph(routeData);

    ArrayList<ArrayList<String>> flightPaths = Search.findAllPaths("FRE", "CMU", routeData.getFlightGraph(), 5, 10);
    // ArrayList<ArrayList<String>> flightPaths = Search.findAllPaths("ACC", "SFO", routeData.getFlightGraph());
    // ArrayList<ArrayList<String>> flightPaths = Search.findAllPaths("ACC", "JFK", routeData.getFlightGraph(), 5, 10);
    // ArrayList<ArrayList<String>> flightPaths = Search.findAllPaths("ADD", "JED", routeData.getFlightGraph());
    Search.printAllPaths(flightPaths);
  }
  
}
