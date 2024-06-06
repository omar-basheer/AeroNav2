
/**
 * The Route class represents a flight route between two airports.
 */
public class Route {
  private String airlineCode;
  private String airlineId;
  private String sourceAirport;
  private String sourceAirportId;
  private String destinationAirport;
  private String destinationAirportId;
  private String stops;

  /**
   * Constructs a Route object with the specified airline code, airline ID, source airport, source airport ID,
   * destination airport, destination airport ID, and number of stops.
   *
   * @param airlineCode the airline code
   * @param airlineId the airline ID
   * @param sourceAirport the source airport
   * @param sourceAirportId the source airport ID
   * @param destinationAirport the destination airport
   * @param destinationAirportId the destination airport ID
   * @param stops the number of stops
   */
  public Route(String airlineCode, String airlineId, String sourceAirport, String sourceAirportId, String destinationAirport,
      String destinationAirportId, String stops) {
    this.airlineCode = airlineCode;
    this.airlineId = airlineId;
    this.sourceAirport = sourceAirport;
    this.sourceAirportId = sourceAirportId;
    this.destinationAirport = destinationAirport;
    this.destinationAirportId = destinationAirportId;
    this.stops = stops;
  }

  /**
   * Returns the airline code of the route.
   *
   * @return the airline code
   */
  public String getAirlineCode() {
    return this.airlineCode;
  }

  /**
   * Returns the airline ID of the route.
   *
   * @return the airline ID
   */
  public String getAirlineId() {
    return this.airlineId;
  }

  /**
   * Returns the source airport of the route.
   *
   * @return the source airport
   */
  public String getSourceAirport() {
    return this.sourceAirport;
  }

  /**
   * Returns the source airport ID of the route.
   *
   * @return the source airport ID
   */
  public String getSourceAirportId() {
    return this.sourceAirportId;
  }

  /**
   * Returns the destination airport of the route.
   *
   * @return the destination airport
   */
  public String getDestinationAirport() {
    return this.destinationAirport;
  }

  /**
   * Returns the destination airport ID of the route.
   *
   * @return the destination airport ID
   */
  public String getDestinationAirportId() {
    return this.destinationAirportId;
  }

  /**
   * Returns the number of stops in the route.
   *
   * @return the number of stops
   */
  public String getStops() {
    return this.stops;
  }

  /**
   * Returns a string representation of the route.
   *
   * @return a string representation of the route
   */
  @Override
  public String toString() {
    return "Route: " + this.sourceAirport + " -> " + this.destinationAirport;
  }
  
}
