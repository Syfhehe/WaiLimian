package sample.eum;

public enum StyleEnum {
  NEO_CHINESE("新中式"), NEO_CLASSICAL("新古典"), MODERN("现代"), OTHERS("其他");

  private String style;

  private StyleEnum(String style) {
    this.style = style;
  }

  public String getStyle() {
    return style;
  }

  public void setStyle(String style) {
    this.style = style;
  }
}
