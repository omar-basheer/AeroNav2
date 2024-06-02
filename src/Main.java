import java.util.ArrayList;
import java.util.HashMap;

public class Main {

  public static void main(String[] args) {

    // Load airport data
    AirportData airports = Parser.parseAirports("files/airports.csv");
    // Parser.printAirports(airports);
    // Parser.printCityAirports(airports);

    // Load airline data
    HashMap<String, Airline> airlines = Parser.parseAirlines("files/airlines.csv");
    // Parser.printAirlines(airlines);

    // Load route data
    RouteData routeData = Parser.parseRoutes("files/routes.csv");
    // Parser.printRoutes(routeData);
    // Parser.printFlightGraph(routeData);

    // Read input file
    ArrayList<String> inputs = Parser.parseInputFile("tests/input.txt", airports.getCityAirports());

    // Find all paths
    ArrayList<ArrayList<String>> flightPaths = Search.findAllPaths(inputs.get(0), inputs.get(1),
        routeData.getFlightGraph(), 14, 2);

  
    ArrayList<PathData> formattedPaths = Search.formatPaths(flightPaths, airports.getAirports(), routeData.getRoutes(), airlines);

    // Write output file
    Parser.parseOutputFile(formattedPaths, "tests/output.txt");
  }

}
