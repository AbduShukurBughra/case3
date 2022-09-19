package com.springbootproject.case3.service;

import com.springbootproject.case3.dao.UserDao;
import com.springbootproject.case3.dto.UserDto;
import com.springbootproject.case3.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class UserEntityService {
    private final UserDao userDao;

    public List<User> findAllUser() {
        return userDao.findAll();
    }

    public Optional getUsersById(Long id) {
        Optional<User> user = userDao.findById(id);
        return user;

    }

    public void save(User user) {
        userDao.save(user);
    }

    public void deleteUser(Long id) {
        userDao.deleteById(id);
    }

    public void updateUser(Long id, UserDto userDto) {
        // 1. id arkilik user ni tapimiz, buning ismi userFromDb
        Optional<User> userFromDb = userDao.findUserById(id);
        if (userFromDb.isPresent()) {
            // 2. user diki uchurni elip userFromDb ning ustige saklaymiz
            User user1 = new User();
            user1.setId(id);
            user1.setName(userDto.getName());
            user1.setEmail(userDto.getEmail());
            user1.setPhoneNumber(userDto.getPhoneNumber());
            user1.setUsertype(userDto.getUsertype());
            userDao.save(user1);
        }else {
            throw new NotFoundException("id is: "+id+" user not found");
        }
    }

    public List<User> getUsersByUserName(String name) {
        List<User> user = userDao.findAllByName(name);
        return user;
    }
}
