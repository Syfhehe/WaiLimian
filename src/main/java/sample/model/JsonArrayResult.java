package sample.model;

import java.util.List;

public class JsonArrayResult<T> {

  private List<T> data;
  private String code;
  private String msssage;

  public JsonArrayResult() {
    this.code = "200";
    this.msssage = "操作成功！";
  }

  /**
   * 若没有数据返回，可以人为指定状态码和提示信息
   * 
   * @param code
   * @param msssage
   */
  public JsonArrayResult(String code, String msssage) {
    this.code = code;
    this.msssage = msssage;
  }

  /**
   * 有数据返回时，状态码为 0，默认提示信息为“操作成功！”
   * 
   * @param data
   */
  public JsonArrayResult(List<T> data) {
    this.data = data;
    this.code = "200";
    this.msssage = "操作成功！";
  }

  /**
   * 有数据返回，状态码为 0，人为指定提示信息
   * 
   * @param data
   * @param msssage
   */
  public JsonArrayResult(List<T> data, String msssage) {
    this.data = data;
    this.code = "200";
    this.msssage = msssage;
  }


  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getMsssage() {
    return msssage;
  }

  public void setMsssage(String msssage) {
    this.msssage = msssage;
  }

  public List<T> getData() {
    return data;
  }

  public void setData(List<T> data) {
    this.data = data;
  }


}
