package sample.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import sample.model.User;
import sample.model.UserWithSalt;
import sample.repository.UserRepository;
import java.util.ArrayList;
import java.util.List;

/**
 * ② 根据 username 获取数据库 user 信息
 */
@Component
public class SelfUserDetailsService implements UserDetailsService {
  // @Override
  // public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
  //
  // //构建用户信息的逻辑(取数据库/LDAP等用户信息)
  // SelfUserDetails userInfo = new SelfUserDetails();
  // userInfo.setUsername(username); // 任意用户名登录
  //
  // Md5PasswordEncoder md5PasswordEncoder = new Md5PasswordEncoder();
  // String encodePassword = md5PasswordEncoder.encodePassword("123456", username); //
  // 模拟从数据库中获取的密码原为 123
  // userInfo.setPassword(encodePassword);
  //
  // Set<GrantedAuthority> authoritiesSet = new HashSet<GrantedAuthority>();
  // GrantedAuthority authority = new SimpleGrantedAuthority("ADMIN"); // 模拟从数据库中获取用户角色
  //
  // authoritiesSet.add(authority);
  // userInfo.setAuthorities(authoritiesSet);
  //
  // return userInfo;
  // }

  private static final Logger logger = LoggerFactory.getLogger(SelfUserDetailsService.class);


  @Autowired
  private UserRepository userRepository;

  public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
    logger.debug("Load user by username: " + userName);
    List<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
    User user = userRepository.findByUserName(userName);
    if (user == null) {
      logger.error("User not found");
      throw new UsernameNotFoundException("User not found");
    }

    authorities.add(new SimpleGrantedAuthority(user.getRole().toString()));
    return new UserWithSalt(user.getUserName(), user.getUserName(), user.getPassword(),
        authorities);
  }
}
