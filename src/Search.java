import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

public class Search {

  public static ArrayList<ArrayList<String>> findAllPaths(String source, String destination, HashMap<String, ArrayList<String>> flightGraph, int maxDepth, int maxPaths) {
    
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
        // add all neighbors of the current node to the queue, check if that the current node is in the graph and not just a destination
        
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

  public static void findShortestPath(ArrayList<ArrayList<String>> foundPaths) {
    ArrayList<String> shortestPath = foundPaths.get(0);

    for (ArrayList<String> path : foundPaths) {
      if (path.size() < shortestPath.size()) {
        shortestPath = path;
      }
    }
    System.out.println("Shortest Path: " + shortestPath.toString());
  }

  public static void findShortestFlight(ArrayList<ArrayList<String>> foundPaths, HashMap<String, Airport> airports){
    ArrayList<String> shortestFlight = foundPaths.get(0);
    double flightDistance = Double.NEGATIVE_INFINITY;

    for(ArrayList<String> path: foundPaths){
      double distance = 0;
      for (int i = 0; i < path.size()-1; i++){
        String curr = path.get(i);
        String next = path.get(i+1);

        double lat1 = airports.get(curr).getLatitude();
        double lon1 = airports.get(curr).getLongitude();
        double lat2 = airports.get(next).getLatitude();
        double lon2 = airports.get(next).getLongitude();

        distance += Haversine.calculateHaversine(lat1, lon1, lat2, lon2);
      }

      System.out.println("Path: " + path.toString());
      System.out.println("Distance: " + distance);

      if (distance > flightDistance){
        flightDistance = distance;
        shortestFlight = path;
      }
    }
    System.out.println("Shortest Flight Distance: " + flightDistance);
    System.out.println("Shortest Flight Path: " + shortestFlight.toString());
  }

  public static void printAllPaths(ArrayList<ArrayList<String>> allPaths) {
    for (ArrayList<String> path : allPaths) {
      System.out.println(path.toString());
    }
  }
}
