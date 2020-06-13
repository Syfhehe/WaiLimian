package exception;

public class NotFoundException extends GlobalException {
  private static final long serialVersionUID = 1907356711699823336L;

  public NotFoundException(String message, int code) {
    super(message, code);
  }
}
