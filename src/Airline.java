
/**
 * The Airline class represents an airline entity.
 */
public class Airline {
  private String name;
  private String iata;
  private String country;
  private String active;

  /**
   * Constructs an Airline object with the specified name, IATA code, country, and active status.
   *
   * @param name    the name of the airline
   * @param iata    the IATA code of the airline
   * @param country the country of the airline
   * @param active  the active status of the airline
   */
  public Airline(String name, String iata, String country, String active) {
    this.name = name;
    this.iata = iata;
    this.country = country;
    this.active = active;
  }

  /**
   * Returns the name of the airline.
   *
   * @return the name of the airline
   */
  public String getName() {
    return this.name;
  }

  /**
   * Returns the IATA code of the airline.
   *
   * @return the IATA code of the airline
   */
  public String getIata() {
    return this.iata;
  }

  /**
   * Returns the country of the airline.
   *
   * @return the country of the airline
   */
  public String getCountry() {
    return this.country;
  }

  /**
   * Returns the active status of the airline.
   *
   * @return the active status of the airline
   */
  public String getActive() {
    return this.active;
  }

  /**
   * Returns a string representation of the Airline object.
   *
   * @return a string representation of the Airline object
   */
  @Override
  public String toString() {
    return "Airline: " + this.name + " (" + this.iata + ")";
  }

}
