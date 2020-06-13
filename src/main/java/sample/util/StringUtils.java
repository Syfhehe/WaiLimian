package sample.util;

public class StringUtils {

  public static boolean isBlank(String s) {
    return s == null || "".equals(s.trim());
  }

  public static boolean isNotBlank(String s) {
    return !isBlank(s);
  }

}
