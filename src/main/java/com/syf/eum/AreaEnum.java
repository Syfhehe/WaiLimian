package com.syf.eum;

public enum AreaEnum {
  
  CORE_DISTRICT("核心区"), ENVIRON("近郊"), OUTSKIRTS("远郊区"), TOWN("城乡区");

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
