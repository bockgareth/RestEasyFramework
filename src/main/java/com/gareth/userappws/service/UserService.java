package com.gareth.userappws.service;

import com.gareth.userappws.SpringApplicationContext;
import com.gareth.userappws.entity.UserEntity;
import com.gareth.userappws.shared.dao.UserDao;
import com.gareth.userappws.shared.dto.UserDto;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

public class UserService {

    UserDao userDao = SpringApplicationContext.getBean("userDao", UserDao.class);

    public List<UserDto> getAllUsers() {
        List<UserDto> returnValue = new ArrayList<>();

        List<UserEntity> users = userDao.getAllUsers();

        for (UserEntity userEntity: users) {
            UserDto userDto = new UserDto();
            BeanUtils.copyProperties(userEntity, userDto);
            returnValue.add(userDto);
        }

        return returnValue;
    }

    public UserDto getUserById(int id) {
        UserEntity user = userDao.getUserById(id);

        UserDto returnValue = new UserDto();
        BeanUtils.copyProperties(user, returnValue);

        return returnValue;
    }

    public UserDto createUser(UserDto user) {
        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(user, userEntity);

        userDao.createUser(userEntity);

        UserDto returnValue = new UserDto();
        BeanUtils.copyProperties(userEntity, returnValue);

        return returnValue;
    }
}
