import java.util.ArrayList;

/**
 * The PathData class represents the data for a specific path in an airline navigation system.
 */
public class PathData {
    ArrayList<String> path;
    double distance;
    ArrayList<String> airlines;

    /**
     * Constructs a PathData object with the specified path, distance, and airlines.
     *
     * @param path     the list of locations in the path
     * @param distance the distance of the path
     * @param airlines the list of airlines operating on the path
     */
    public PathData(ArrayList<String> path, double distance, ArrayList<String> airlines) {
        this.path = path;
        this.distance = distance;
        this.airlines = airlines;
    }
}
  
