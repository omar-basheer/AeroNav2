public class Airline {
  private String name;
  private String icao;
  private String country;
  private String active;

  public Airline(String name, String icao, String country, String active) {
    this.name = name;
    this.icao = icao;
    this.country = country;
    this.active = active;
  }

  public String getName() {
    return this.name;
  }

  public String getIcao() {
    return this.icao;
  }

  public String getCountry() {
    return this.country;
  }

  public String getActive() {
    return this.active;
  }

}
