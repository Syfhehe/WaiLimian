package sample.eum;

public enum LaterEnum {

  CLUB("会所"), BUSINESS("商业"),SCHOOL("学校"), APAERTMENT("公寓"), TEMPORARY_BUILDING("临时建筑"), OTHERS("其他");

  private LaterEnum(String later) {
    this.later = later;
  }

  private String later;

  public String getLater() {
    return later;
  }

  public void setLater(String later) {
    this.later = later;
  }

}
