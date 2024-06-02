import java.util.ArrayList;
import java.util.HashMap;


public class AirportData {

  private HashMap<String, Airport> airports;
  private HashMap<ArrayList<String>, String> cityAirports;

  public AirportData(HashMap<String, Airport> airports, HashMap<ArrayList<String>, String> cityAirports){
    this.airports = airports;
    this.cityAirports = cityAirports;
  }

  public HashMap<String, Airport> getAirports() {
    return this.airports;
  }

  public HashMap<ArrayList<String>, String> getCityAirports() {
    return this.cityAirports;
  }
}
