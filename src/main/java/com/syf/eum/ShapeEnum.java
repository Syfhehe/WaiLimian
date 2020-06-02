package com.syf.eum;

public enum ShapeEnum {

  BOX("盒子"), BLOCK("体块"), HETEROMORPHISM("异形"), OTHERS("其他");

  private String shape;

  private ShapeEnum(String shape) {
    this.shape = shape;
  }

  public String getShape() {
    return shape;
  }

  public void setShape(String shape) {
    this.shape = shape;
  }


}
