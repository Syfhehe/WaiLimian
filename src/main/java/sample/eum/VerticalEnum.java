package sample.eum;

public enum VerticalEnum {

  OVERGROUND("全地上"), UNDERGOROUND("商业"), OTHERS("其他");

  private VerticalEnum(String vertical) {
    this.vertical = vertical;
  }

  private String vertical;

  public String getVertical() {
    return vertical;
  }

  public void setVertical(String vertical) {
    this.vertical = vertical;
  }



}
