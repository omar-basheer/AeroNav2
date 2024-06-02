import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Parser {

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
            cityKey.add(splitStream[2].toLowerCase());
            cityKey.add(splitStream[3].toLowerCase());
            cityAirports.putIfAbsent(cityKey, splitStream[4]);

          } catch (NumberFormatException e) {
            // System.err.println("Error parsing float values for line: " + streamline);
            // System.err.println(
            // "Latitude: " + splitStream[6] +
            // ", Longitude: " + splitStream[7]
            // );
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

        if (!splitStream[7].equals("N") && !splitStream[3].equals("")) {
          // use iata as key for hashmap
          String key = splitStream[3];
          airlines.putIfAbsent(key, new Airline(
              splitStream[1], // name
              splitStream[3], // iata
              splitStream[6], // country
              splitStream[7] // active
          ));
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
        key.add(splitStream[2]); // source airport iata
        key.add(splitStream[4]); // destination airport iata

        routes.putIfAbsent(key, new Route(
            splitStream[0], // airline code
            splitStream[1], // airline id
            splitStream[2], // source airport iata
            splitStream[3], // source airport id
            splitStream[4], // destination airport iata
            splitStream[5], // destination airport id
            splitStream[7] // stops
        ));
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

  public static void printCityAirports(AirportData airportData) {
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

  public static ArrayList<String> parseInputFile(String filename, HashMap<ArrayList<String>, String> cityAirports) {
    Scanner inputStream;
    String streamline;
    String[] splitStream;
    ArrayList<String> inputs = new ArrayList<String>();

    try {
      inputStream = new Scanner(new FileInputStream(filename));
      while (inputStream.hasNext()) {
        streamline = inputStream.nextLine();
        splitStream = streamline.split(", ");
        ArrayList<String> params = new ArrayList<String>();
        for (String param : splitStream) {
          params.add(param.toLowerCase());
        }
        if (cityAirports.containsKey(params)) {
          inputs.add(cityAirports.get(params).toString());
        } else {
          System.out.println("Invalid input: " + params.toString());
          break;
        }
      }
      inputStream.close();
      System.out.println("Inputs loaded: " + inputs.toString());

    } catch (FileNotFoundException e) {
      System.out.println("File not found");
      return null;
    }

    return inputs;
  }

  public static void parseOutputFile(ArrayList<PathData> pathsWithDistances,
      String filename) {
    try (FileWriter writer = new FileWriter(filename)) {

      PathData shortestPath = pathsWithDistances.get(0);
      for (PathData pwd : pathsWithDistances) {
        if (pwd.distance < shortestPath.distance) {
          shortestPath = pwd;
        }
      }
      // write the shortest path
      writer.write("Shortest Path:\n");
      for (int i = 0; i < shortestPath.path.size() - 1; i++) {
        writer.write((i + 1) + ". " + shortestPath.airlines.get(i) + " from " + shortestPath.path.get(i) + " to "
            + shortestPath.path.get(i + 1) + "\n");
      }
      writer.write("Total flights: " + (shortestPath.path.size() - 1) + "\n");
      writer.write("Total flight distance: " + shortestPath.distance + " kilometers\n\n");

      // write all paths with distance information
      writer.write("All Paths with Distance Information:\n");
      for (PathData pwd : pathsWithDistances) {
        writer.write("Path:\n");
        for (int i = 0; i < pwd.path.size() - 1; i++) {
          writer.write(
              (i + 1) + ". " + pwd.airlines.get(i) + " from " + pwd.path.get(i) + " to " + pwd.path.get(i + 1) + "\n");
        }
        writer.write("Total flights: " + (pwd.path.size() - 1) + "\n");
        writer.write("Total flight distance: " + pwd.distance + " kilometers\n\n");
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

}
