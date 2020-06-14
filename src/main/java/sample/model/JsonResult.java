package sample.model;

public class JsonResult<T> {

  private T data;
  private int code;
  private String msssage;

  public JsonResult() {
    this.code = 200;
    this.msssage = "操作成功！";
  }

  /**
   * 若没有数据返回，可以人为指定状态码和提示信息
   * 
   * @param code
   * @param msssage
   */
  public JsonResult(int code, String msssage) {
    this.code = code;
    this.msssage = msssage;
  }

  /**
   * 有数据返回时，状态码为 0，默认提示信息为“操作成功！”
   * 
   * @param data
   */
  public JsonResult(T data) {
    this.data = data;
    this.code = 200;
    this.msssage = "操作成功！";
  }

  /**
   * 有数据返回，状态码为 0，人为指定提示信息
   * 
   * @param data
   * @param msssage
   */
  public JsonResult(T data, String msssage) {
    this.data = data;
    this.code = 200;
    this.msssage = msssage;
  }

  public T getData() {
    return data;
  }

  public void setData(T data) {
    this.data = data;
  }

  public int getCode() {
    return code;
  }

  public void setCode(int code) {
    this.code = code;
  }

  public String getMsssage() {
    return msssage;
  }

  public void setMsssage(String msssage) {
    this.msssage = msssage;
  }


}
