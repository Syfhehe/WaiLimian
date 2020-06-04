package com.syf.service;


import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.syf.exception.NotFoundException;
import com.syf.exception.Result;
import com.syf.model.User;
import com.syf.repository.UserRepository;

import java.util.List;

import static com.syf.util.Util.getNullPropertyNames;

@Service
public class ProjectService
{
    @Autowired
    private UserRepository userRepository;

    public Object addUser(User user)
    {
        return userRepository.save(user);
    }

    public List<User> getUserList()
    {
        return userRepository.findAll();
    }

    public Object getUser(Long id) throws NotFoundException
    {
        User currentInstance = userRepository.findOne(id);
        if (currentInstance == null)
        {
            throw new NotFoundException("user " + id + " is not exist!", Result.ErrorCode.USER_NOT_FOUND.getCode());
        }
        return userRepository.findOne(id);
    }

    public void deleteUser(Long id)
    {
        userRepository.delete(id);
    }

    public User update(Long id, User user)
    {
        User currentInstance = userRepository.findOne(id);

        String[] nullPropertyNames = getNullPropertyNames(user);
        BeanUtils.copyProperties(user, currentInstance, nullPropertyNames);

        return userRepository.save(currentInstance);
    }
}
