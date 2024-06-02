import java.util.ArrayList;
import java.util.HashMap;

public class Main {

    @SuppressWarnings("unused")
    public static void main(String[] args) {

    AirportData airports = CsvParser.parseAirports("files/airports.csv");
    // CsvParser.printAirports(airports);
    // CsvParser.printCityRoutes(airports);

    HashMap<String, Airline> airlines = CsvParser.parseAirlines("files/airlines.csv");
    // CsvParser.printAirlines(airlines);

    RouteData routeData = CsvParser.parseRoutes("files/routes.csv");
    // CsvParser.printRoutes(routeData);
    // CsvParser.printFlightGraph(routeData);

    // ArrayList<ArrayList<String>> flightPaths = Search.findAllPaths("FRE", "CMU", routeData.getFlightGraph(), 5, 10);
    ArrayList<ArrayList<String>> flightPaths = Search.findAllPaths("ACC", "SFO", routeData.getFlightGraph(), 5, 15);
    // ArrayList<ArrayList<String>> flightPaths = Search.findAllPaths("ACC", "JFK", routeData.getFlightGraph(), 5, 10);
    // ArrayList<ArrayList<String>> flightPaths = Search.findAllPaths("ADD", "JED", routeData.getFlightGraph());
    Search.printAllPaths(flightPaths);
    Search.findShortestPath(flightPaths);
    Search.findShortestFlight(flightPaths, airports.getAirports());
  
    
  }
  
}
