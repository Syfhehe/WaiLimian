package sample.bean;

import java.io.Serializable;

public class AjaxResponseBody implements Serializable {

  /**
  * 
  */
  private static final long serialVersionUID = 1L;
  private int code;
  private String message;
  private Object result;
  private String jwtToken;
  private Object data;

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

  public Object getData() {
    return data;
  }

  public void setData(Object data) {
    this.data = data;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

}
