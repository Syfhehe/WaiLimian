package sample.eum;

public enum PositionEnum {

  CORE_DISTRICT("核心区"), ENVIRON("近郊"), OUTSKIRTS("远郊区"), TOWN("城乡区");

  private PositionEnum(String position) {
    this.position = position;
  }

  private String position;

  public String getPosition() {
    return position;
  }

  public void setPosition(String position) {
    this.position = position;
  }

}
