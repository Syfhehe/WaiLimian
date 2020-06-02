package com.syf.eum;

public enum ScopeEnum {

  SMALL("<800"), MIDDLE("800-1500"), BIG(">1500");

  private ScopeEnum(String scope) {
    this.scope = scope;
  }

  private String scope;

  public String getScope() {
    return scope;
  }

  public void setScope(String scope) {
    this.scope = scope;
  }

}
