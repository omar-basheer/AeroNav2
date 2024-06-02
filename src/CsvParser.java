import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class CsvParser {

  public static AirportData parseAirports(String fliename) {
    Scanner inputStream;
    String streamline;
    String[] splitStream;
    HashMap<String, Airport> airports = new HashMap<String, Airport>();
    HashMap<ArrayList<String>, String> cityAirports = new HashMap<ArrayList<String>, String>();

    try {
      inputStream = new Scanner(new FileInputStream(fliename));
      while (inputStream.hasNext()) {
        streamline = inputStream.nextLine();
        splitStream = streamline.split(",");

        if (!(splitStream[4].equals("\\N"))) {
          // use iata as key for hashmap
          String key = splitStream[4];

          try {
            double latitude = Double.parseDouble(splitStream[6]);
            double longitude = Double.parseDouble(splitStream[7]);
            // double timezone = Double.parseDouble(splitStream[9]);

            airports.putIfAbsent(key, new Airport(
                splitStream[1], // Name
                splitStream[2], // City
                splitStream[3], // Country
                splitStream[4], // IATA
                splitStream[5], // ICAO
                latitude, // Latitude
                longitude, // Longitude
                splitStream[9] // Timezone
            ));

            // use city + country as key for hashmap
            ArrayList<String> cityKey = new ArrayList<String>();
            cityKey.add(splitStream[2]);
            cityKey.add(splitStream[3]);
            cityAirports.putIfAbsent(cityKey, splitStream[4]);

          } catch (NumberFormatException e) {
            // System.err.println("Error parsing float values for line: " + streamline);
            // System.err.println(
            //   "Latitude: " + splitStream[6] + 
            //   ", Longitude: " + splitStream[7]
            //   );
          }

        }
      }
      inputStream.close();
      System.out.println("Airports loaded");

    } catch (FileNotFoundException e) {
      System.out.println("File not found");
      return null;
    }
    return new AirportData(airports, cityAirports);
  }

  public static HashMap<String, Airline> parseAirlines(String filename) {
    Scanner inputStream;
    String streamline;
    String[] splitStream;
    HashMap<String, Airline> airlines = new HashMap<String, Airline>();

    try {
      inputStream = new Scanner(new FileInputStream(filename));
      while (inputStream.hasNext()) {
        streamline = inputStream.nextLine();
        splitStream = streamline.split(",");

        if (!(splitStream[7].equals("N"))) {
          // use icao as key for hashmap
          String key = splitStream[4];
          airlines.putIfAbsent(key, new Airline(splitStream[1], splitStream[4], splitStream[6], splitStream[7]));
        }
      }
      inputStream.close();
      System.out.println("Airlines loaded");

    } catch (FileNotFoundException e) {
      System.out.println("File not found");
      return null;
    }
    return airlines;
  }

  public static RouteData parseRoutes(String filename) {
    Scanner inputStream;
    String streamline;
    String[] splitStream;
    HashMap<String, ArrayList<String>> flightGraph = new HashMap<String, ArrayList<String>>();
    HashMap<ArrayList<String>, Route> routes = new HashMap<ArrayList<String>, Route>();

    try {
      inputStream = new Scanner(new FileInputStream(filename));
      while (inputStream.hasNext()) {
        streamline = inputStream.nextLine();
        splitStream = streamline.split(",");

        // add route to flight graph
        if (flightGraph.containsKey(splitStream[2])) {
          flightGraph.get(splitStream[2]).add(splitStream[4]);
        } else {
          ArrayList<String> destinations = new ArrayList<String>();
          destinations.add(splitStream[4]);
          flightGraph.putIfAbsent(splitStream[2], destinations);
        }

        // add route to routes
        ArrayList<String> key = new ArrayList<String>();
        key.add(splitStream[2]);
        key.add(splitStream[4]);

        routes.putIfAbsent(key, new Route(splitStream[0], splitStream[1], splitStream[2], splitStream[3],
            splitStream[4], splitStream[5], splitStream[7]));
      }
      inputStream.close();
      System.out.println("Routes loaded");
    } catch (FileNotFoundException e) {
      System.out.println("File not found");
      return null;
    }
    return new RouteData(flightGraph, routes);
  }

  public static void printAirports(AirportData airportData) {
    for (String key : airportData.getAirports().keySet()) {
      System.out.println(airportData.getAirports().get(key).getName().toString());
      // System.out.println(key.toString() + " -> " + airports.get(key).toString());
      // System.out.println(airports.get(key).toString());
    }
  }

  public static void printCityRoutes(AirportData airportData) {
    for (ArrayList<String> key : airportData.getCityAirports().keySet()) {
      System.out.println(airportData.getCityAirports().get(key).toString());
    }
  }

  public static void printAirlines(HashMap<String, Airline> airlines) {
    for (String key : airlines.keySet()) {
      // System.out.println(airlines.get(key).getName().toString());
      System.out.println(airlines.get(key).toString());
    }
  }

  public static void printRoutes(RouteData routeData) {
    for (ArrayList<String> key : routeData.getRoutes().keySet()) {
      System.out.println(routeData.getRoutes().get(key).toString());
    }
  }

  public static void printFlightGraph(RouteData routeData) {
    for (String key : routeData.getFlightGraph().keySet()) {
      System.out.println(key + " -> " + routeData.getFlightGraph().get(key).toString());
    }
  }

  public static void main(String[] args) {
    AirportData airports = parseAirports("files/airports.csv");
    printAirports(airports);

    HashMap<String, Airline> airlines = parseAirlines("files/airlines.csv");
    printAirlines(airlines);

    RouteData routeData = parseRoutes("files/routes.csv");
    printRoutes(routeData);
    // printFlightGraph(routeData);
  }

}
