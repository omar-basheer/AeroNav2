public class Airline {
  private String name;
  private String iata;
  private String country;
  private String active;

  public Airline(String name, String iata, String country, String active) {
    this.name = name;
    this.iata = iata;
    this.country = country;
    this.active = active;
  }

  public String getName() {
    return this.name;
  }

  public String getIata() {
    return this.iata;
  }

  public String getCountry() {
    return this.country;
  }

  public String getActive() {
    return this.active;
  }

  @Override
  public String toString() {
    return "Airline: " + this.name + " (" + this.iata + ")";
  }

}
