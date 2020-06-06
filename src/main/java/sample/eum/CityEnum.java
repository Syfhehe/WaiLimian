package sample.eum;

public enum CityEnum {

  FIRST_TIER("一线"), SECOND_TIER("二线"), THIRD_FOURTH_TIER("三四线");

  private String city;

  private CityEnum(String city) {
      this.city = city;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

}
