package sample.util;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

public class PageUtil {
  public static PageRequest getPageRequest(Integer pageNumber, Integer pageSize, String field) {
    Sort sort = null;
    // 默认页面为0，
    if (pageNumber == null || pageNumber < 1) {
      pageNumber = 0;
    } else {
      pageNumber = pageNumber - 1;
    }
    // 默认页面大小18
    if (pageSize == null || pageSize < 1) {
      pageSize = 18;
    }
    // 默认采用ID倒叙排列
    if (field == null) {
      sort = null;
    } else {
      sort = new Sort(Sort.Direction.DESC, field);
    }
    return new PageRequest(pageNumber, pageSize, sort);
  }

  public static PageRequest getPageRequest() {
    return getPageRequest(null, null, null);
  }

  public static PageRequest getPageRequest(Integer pageNumber, Integer pageSize) {
    return getPageRequest(pageNumber, pageSize, null);
  }
}
