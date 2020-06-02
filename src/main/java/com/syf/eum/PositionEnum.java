package com.syf.eum;

public enum PositionEnum {

  CENTRAL_AXIS("中轴"), ALONG_STREET("沿街"), CORNER("转角"), REMOTE("异地"), DIAGONAL("对角");

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
