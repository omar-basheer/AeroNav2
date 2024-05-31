public class Route {
  private String airlineCode;
  private String airlineId;
  private String sourceAirport;
  private String sourceAirportId;
  private String destinationAirport;
  private String destinationAirportId;
  private String stops;

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

  public String getAirlineCode() {
    return this.airlineCode;
  }

  public String getAirlineId() {
    return this.airlineId;
  }

  public String getSourceAirport() {
    return this.sourceAirport;
  }

  public String getSourceAirportId() {
    return this.sourceAirportId;
  }

  public String getDestinationAirport() {
    return this.destinationAirport;
  }

  public String getDestinationAirportId() {
    return this.destinationAirportId;
  }

  public String getStops() {
    return this.stops;
  }


  @Override
  public String toString() {
    return "Route: " + this.sourceAirport + " -> " + this.destinationAirport;
  }
  
}
