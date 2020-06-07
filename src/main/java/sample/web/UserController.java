package sample.web;

import io.swagger.annotations.ApiOperation;
import sample.model.User;
import sample.repository.UserRepository;
import sample.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import exception.NotFoundException;

@RestController
@RequestMapping("")
public class UserController
{
    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    // code data 数据都在data里
    @ApiOperation(value="获取用户信息", notes="根据id获取用户信息")
    @GetMapping(value = "/user_info")
    public Object getUser() throws NotFoundException 
    {
//        User user =  userService.getCurrentUser();
//        user.setPassword(null);
        return userRepository.findOne(1l);
    }

}
