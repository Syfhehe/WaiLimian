package sample.config;

import com.alibaba.fastjson.JSON;
import sample.bean.AjaxResponseBody;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class AjaxAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

  @Override
  public void onAuthenticationSuccess(HttpServletRequest httpServletRequest,
      HttpServletResponse httpServletResponse, Authentication authentication)
      throws IOException, ServletException {
    AjaxResponseBody responseBody = new AjaxResponseBody();

    responseBody.setCode(200);
    responseBody.setMessage("Login Success!");

    httpServletResponse.getWriter().write(JSON.toJSONString(responseBody));
  }
}

