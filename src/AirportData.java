import java.util.ArrayList;
import java.util.HashMap;

/**
 * The AirportData class represents a collection of airport data.
 * It contains information about airports and their corresponding cities.
 */
public class AirportData {

  private HashMap<String, Airport> airports;
  private HashMap<ArrayList<String>, String> cityAirports;

  /**
   * Constructs an AirportData object with the specified airports and cityAirports.
   * 
   * @param airports a HashMap containing airport codes as keys and Airport objects as values
   * @param cityAirports a HashMap containing lists of city and country names as keys and a string representing the corresponding airport code as value
   */
  public AirportData(HashMap<String, Airport> airports, HashMap<ArrayList<String>, String> cityAirports){
    this.airports = airports;
    this.cityAirports = cityAirports;
  }

  /**
   * Returns the HashMap of airports.
   * 
   * @return the HashMap of airports
   */
  public HashMap<String, Airport> getAirports() {
    return this.airports;
  }

  /**
   * Returns the HashMap of city airports.
   * 
   * @return the HashMap of city airports
   */
  public HashMap<ArrayList<String>, String> getCityAirports() {
    return this.cityAirports;
  }
}
