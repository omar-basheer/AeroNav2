
/**
 * The Haversine class provides a method to calculate the distance between two points on the Earth's surface using the Haversine formula.
 */
public class Haversine {

  /**
   * Calculates the distance between two points on the Earth's surface using the Haversine formula.
   *
   * @param lat1 The latitude of the first point.
   * @param lon1 The longitude of the first point.
   * @param lat2 The latitude of the second point.
   * @param lon2 The longitude of the second point.
   * @return The distance between the two points in kilometers.
   */
  public static double calculateHaversine(double lat1, double lon1, double lat2, double lon2){
    double dLat  = Math.toRadians(lat2 - lat1);
    double dLong = Math.toRadians(lon2 - lon1);

    // Convert lat1 and lat2 to radians
    lat1 = Math.toRadians(lat1);
    lat2 = Math.toRadians(lat2);

    // Apply formula
    double a = Math.pow(Math.sin(dLat / 2), 2) + Math.pow(Math.sin(dLong / 2), 2) * Math.cos(lat1) * Math.cos(lat2);
    double rad = 6371;
    double c = 2 * Math.asin(Math.sqrt(a));

    return rad * c;
  }
}