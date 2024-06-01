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

  public static ArrayList<String> findShortestPath(String source, String destination,
      HashMap<String, ArrayList<String>> flightGraph) {
    ArrayList<ArrayList<String>> allPaths = findAllPaths(source, destination, flightGraph, 5, 10);
    ArrayList<String> shortestPath = allPaths.get(0);

    for (ArrayList<String> path : allPaths) {
      if (path.size() < shortestPath.size()) {
        shortestPath = path;
      }
    }
    return shortestPath;
  }

  public static void printAllPaths(ArrayList<ArrayList<String>> allPaths) {
    for (ArrayList<String> path : allPaths) {
      System.out.println(path.toString());
    }
  }
}
