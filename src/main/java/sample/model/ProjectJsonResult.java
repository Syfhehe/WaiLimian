package sample.model;

public class ProjectJsonResult<T> {

  private T data;
  private int code;
  private String msssage;
  private int page_no = 0;
  private int page_size = 0;
  private int total = 0;

  public ProjectJsonResult() {
    this.code = 200;
    this.msssage = "操作成功！";
  }

  /**
   * 若没有数据返回，可以人为指定状态码和提示信息
   * 
   * @param code
   * @param msssage
   */
  public ProjectJsonResult(int code, String msssage) {
    this.code = code;
    this.msssage = msssage;
  }

  /**
   * 有数据返回时，状态码为 0，默认提示信息为“操作成功！”
   * 
   * @param data
   */
  public ProjectJsonResult(T data) {
    this.data = data;
    this.code = 200;
    this.msssage = "操作成功！";
  }

  public ProjectJsonResult(T data, int page_no, int page_size, int total) {
    this.data = data;
    this.code = 200;
    this.msssage = "操作成功！";
    this.page_no = page_no;
    this.page_size = page_size;
    this.total = total;
  }

  /**
   * 有数据返回，状态码为 0，人为指定提示信息
   * 
   * @param data
   * @param msssage
   */
  public ProjectJsonResult(T data, String msssage) {
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

  public int getPage_no() {
    return page_no;
  }

  public void setPage_no(int page_no) {
    this.page_no = page_no;
  }

  public int getPage_size() {
    return page_size;
  }

  public void setPage_size(int page_size) {
    this.page_size = page_size;
  }

  public int getTotal() {
    return total;
  }

  public void setTotal(int total) {
    this.total = total;
  }


}
