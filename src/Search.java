import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

/**
 * The Search class provides methods for finding paths between airports in a flight graph.
 */
public class Search {

  /**
   * Finds all paths between a source and destination airport in a flight graph.
   *
   * @param source The source airport.
   * @param destination The destination airport.
   * @param flightGraph The flight graph represented as a HashMap.
   * @param maxDepth The maximum depth of the paths to be found.
   * @param maxPaths The maximum number of paths to be found.
   * @return An ArrayList of ArrayLists representing all the paths found.
   */
  public static ArrayList<ArrayList<String>> findAllPaths(String source, String destination,
      HashMap<String, ArrayList<String>> flightGraph, int maxDepth, int maxPaths) {

    ArrayList<ArrayList<String>> allPaths = new ArrayList<ArrayList<String>>();
    Queue<ArrayList<String>> queue = new ArrayDeque<>();
    Set<ArrayList<String>> exploredPaths = new HashSet<>();
    int pathCount = 0;

    // initialize queue with source (path to source)
    ArrayList<String> path = new ArrayList<>();
    path.add(source);
    queue.add(path);
    exploredPaths.add(path);

    while (!queue.isEmpty() && pathCount < maxPaths) {
      // get the first path from the queue
      ArrayList<String> currentPath = queue.poll();
      String currentNode = currentPath.get(currentPath.size() - 1);

      // if the current node is the destination, add the path to allPaths
      if (currentNode.equals(destination)) {
        allPaths.add(currentPath);
        pathCount++;

      } else if (currentPath.size() <= maxDepth) {
        // add all neighbors of the current node to the queue,
        // check if the current node is in the graph and not just a destination

        if (flightGraph.containsKey(currentNode)) {

          for (String neighbor : flightGraph.get(currentNode)) {

            if (!currentPath.contains(neighbor)) {
              ArrayList<String> newPath = new ArrayList<>(currentPath);
              newPath.add(neighbor);

              // Check if this new path has been explored already
              if (!exploredPaths.contains(newPath)) {
                queue.add(newPath);
                exploredPaths.add(newPath);
              }
            }

          }
        }
      }
    }
    return allPaths;

  }

  /**
   * Finds the shortest path among the given paths.
   *
   * @param foundPaths The ArrayList of ArrayLists representing the paths.
   * @return The shortest path as an ArrayList of Strings.
   * @deprecated This method is deprecated and may be removed in future versions.
   */
  @Deprecated
  public static ArrayList<String> findShortestPath(ArrayList<ArrayList<String>> foundPaths) {
    ArrayList<String> shortestPath = foundPaths.get(0);

    for (ArrayList<String> path : foundPaths) {
      if (path.size() < shortestPath.size()) {
        shortestPath = path;
      }
    }
    return shortestPath;
  }

  /**
   * Formats the found paths with additional information.
   *
   * @param foundPaths The ArrayList of ArrayLists representing the paths.
   * @param airports The HashMap of airports.
   * @param routes The HashMap of routes.
   * @param airlines The HashMap of airlines.
   * @return An ArrayList of PathData objects representing the formatted paths.
   */
  public static ArrayList<PathData> formatPaths(ArrayList<ArrayList<String>> foundPaths,
      HashMap<String, Airport> airports, HashMap<ArrayList<String>, Route> routes, HashMap<String, Airline> airlines) {
    ArrayList<PathData> pathsWithDistances = new ArrayList<>();

    for (ArrayList<String> path : foundPaths) {
      double totalDistance = 0;
      ArrayList<String> airlinesList = new ArrayList<>();
      boolean validPath = true;

      for (int i = 0; i < path.size() - 1; i++) {
        String curr = path.get(i);
        String next = path.get(i + 1);

        ArrayList<String> routeKey = new ArrayList<>();
        routeKey.add(curr);
        routeKey.add(next);

        if (routes.containsKey(routeKey)) {
          Route route = routes.get(routeKey);
          String airlineCode = route.getAirlineCode();

          if (airlines.containsKey(airlineCode)) {
            airlinesList.add(airlineCode);
          } else {
            validPath = false;
            break;
          }
          // calculate distance between airports
          double lat1 = airports.get(curr).getLatitude();
          double lon1 = airports.get(curr).getLongitude();
          double lat2 = airports.get(next).getLatitude();
          double lon2 = airports.get(next).getLongitude();

          totalDistance += Haversine.calculateHaversine(lat1, lon1, lat2, lon2);
        } else {
          validPath = false;
          break;
        }

      }
      if (validPath) {

        pathsWithDistances.add(new PathData(path, totalDistance, airlinesList));
      }
    }
    return pathsWithDistances;
  }

  /**
   * Prints all the paths.
   *
   * @param allPaths The ArrayList of ArrayLists representing the paths.
   */
  public static void printAllPaths(ArrayList<ArrayList<String>> allPaths) {
    for (ArrayList<String> path : allPaths) {
      System.out.println(path.toString());
    }
  }
}
