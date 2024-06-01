public class Airport {
  private String name;
  private String city;
  private String country;
  private String iata;
  private String icao;
  private String latitude;
  private String longitude;
  private String timezone;

  public Airport(String name, String city, String country, String iata, String icao, String latitude, String longitude,
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

  public String getName() {
    return this.name;
  }

  public String getCity() {
    return this.city;
  }

  public String getCountry() {
    return this.country;
  }

  public String getIata() {
    return this.iata;
  }

  public String getIcao() {
    return this.icao;
  }

  public String getLatitude() {
    return this.latitude;
  }

  public String getLongitude() {
    return this.longitude;
  }

  public String getTimezone() {
    return this.timezone;
  }

  @Override
  public String toString() {
    return "Airport: " + this.name + " (" + this.iata + ")" + " (" + this.icao + ")";
  }

}