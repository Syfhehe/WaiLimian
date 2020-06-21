package sample.util;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import java.beans.FeatureDescriptor;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.stream.Stream;

public class Util {

  public static String[] getNullPropertyNames(Object source) {
    final BeanWrapper wrappedSource = new BeanWrapperImpl(source);
    return Stream.of(wrappedSource.getPropertyDescriptors()).map(FeatureDescriptor::getName)
        .filter(propertyName -> wrappedSource.getPropertyValue(propertyName) == null)
        .toArray(String[]::new);
  }

  public static String formatDateTime(Date date) {
    if (date == null) {
      date = new Date();
    }
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
    String formatStr = formatter.format(date);
    return formatStr;
  }

  public static String formatDate(Date date) {
    if (date == null) {
      date = new Date();
    }
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy.MM.dd");
    String formatStr = formatter.format(date);
    return formatStr;
  }

}
