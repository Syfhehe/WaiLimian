package sample.config;

import com.alibaba.fastjson.JSON;
import sample.bean.AjaxResponseBody;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class AjaxAuthenticationEntryPoint implements AuthenticationEntryPoint {

  @Override
  public void commence(HttpServletRequest httpServletRequest,
      HttpServletResponse httpServletResponse, AuthenticationException e)
      throws IOException, ServletException {
    AjaxResponseBody responseBody = new AjaxResponseBody();

    responseBody.setCode(000);
    responseBody.setMessage("Need Authorities!");

    httpServletResponse.getWriter().write(JSON.toJSONString(responseBody));
  }
}
