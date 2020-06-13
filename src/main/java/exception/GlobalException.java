package exception;

public class GlobalException extends Exception {

  private static final long serialVersionUID = -8405846291033056621L;

  private int code;

  public GlobalException(String message) {
    super(message);
  }

  public GlobalException(String message, int code) {
    super(message);
    this.code = code;
  }

  public void setCode(int code) {
    this.code = code;
  }

  public int getCode() {
    return code;
  }
}

