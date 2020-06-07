package sample.bean;

import java.io.Serializable;

public class AjaxResponseBody implements Serializable {

  /**
  * 
  */
  private static final long serialVersionUID = 1L;
  private int code;
  private String msg;
  private Object result;
  private String jwtToken;


  public String getMsg() {
    return msg;
  }

  public void setMsg(String msg) {
    this.msg = msg;
  }

  public Object getResult() {
    return result;
  }

  public void setResult(Object result) {
    this.result = result;
  }

  public String getJwtToken() {
    return jwtToken;
  }

  public void setJwtToken(String jwtToken) {
    this.jwtToken = jwtToken;
  }

  public int getCode() {
    return code;
  }

  public void setCode(int code) {
    this.code = code;
  }

}
