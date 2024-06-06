
/**
 * The Airport class represents an airport entity.
 */
public class Airport {
  private String name;
  private String city;
  private String country;
  private String iata;
  private String icao;
  private double latitude;
  private double longitude;
  private String timezone;

  /**
   * Constructs an Airport object with the specified parameters.
   *
   * @param name      the name of the airport
   * @param city      the city where the airport is located
   * @param country   the country where the airport is located
   * @param iata      the IATA code of the airport
   * @param icao      the ICAO code of the airport
   * @param latitude  the latitude of the airport's location
   * @param longitude the longitude of the airport's location
   * @param timezone  the timezone of the airport
   */
  public Airport(String name, String city, String country, String iata, String icao, double latitude, double longitude,
      String timezone) {
    this.name = name;
    this.city = city;
    this.country = country;
    this.iata = iata;
    this.icao = icao;
    this.latitude = latitude;
    this.longitude = longitude;
    this.timezone = timezone;
  }

  /**
   * Returns the name of the airport.
   *
   * @return the name of the airport
   */
  public String getName() {
    return this.name;
  }

  /**
   * Returns the city where the airport is located.
   *
   * @return the city where the airport is located
   */
  public String getCity() {
    return this.city;
  }

  /**
   * Returns the country where the airport is located.
   *
   * @return the country where the airport is located
   */
  public String getCountry() {
    return this.country;
  }

  /**
   * Returns the IATA code of the airport.
   *
   * @return the IATA code of the airport
   */
  public String getIata() {
    return this.iata;
  }

  /**
   * Returns the ICAO code of the airport.
   *
   * @return the ICAO code of the airport
   */
  public String getIcao() {
    return this.icao;
  }

  /**
   * Returns the latitude of the airport's location.
   *
   * @return the latitude of the airport's location
   */
  public double getLatitude() {
    return this.latitude;
  }

  /**
   * Returns the longitude of the airport's location.
   *
   * @return the longitude of the airport's location
   */
  public double getLongitude() {
    return this.longitude;
  }

  /**
   * Returns the timezone of the airport.
   *
   * @return the timezone of the airport
   */
  public String getTimezone() {
    return this.timezone;
  }

  /**
   * Returns a string representation of the airport.
   *
   * @return a string representation of the airport
   */
  @Override
  public String toString() {
    return "Airport: " + this.name + " (" + this.iata + ")" + " (" + this.icao + ")";
  }

}