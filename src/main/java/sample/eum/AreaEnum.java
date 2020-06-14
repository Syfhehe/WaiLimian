package sample.eum;

public enum AreaEnum {

  CENTRAL_AXIS("中轴"), ALONG_STREET("沿街"), CORNER("转角"), REMOTE("异地"), DIAGONAL("对角");

  private String area;

  private AreaEnum(String area) {
    this.area = area;
  }

  public String getArea() {
    return area;
  }

  public void setArea(String area) {
    this.area = area;
  }

}
