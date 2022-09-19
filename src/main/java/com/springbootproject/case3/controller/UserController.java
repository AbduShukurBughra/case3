package com.springbootproject.case3.controller;

import com.springbootproject.case3.dto.UserDto;
import com.springbootproject.case3.entity.User;
import com.springbootproject.case3.service.UserEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    @Autowired
    private UserEntityService userEntityService;

//   •	Tüm kullanıcıları getiren bir servis yazınız.
    @GetMapping()
    public ResponseEntity findAllUser(){
        List<User> users = userEntityService.findAllUser();
        return ResponseEntity.ok(users);
    }

    //   •	Kullanıcı idsinden kullanıcıyı getiren bir servis yazınız.
    @GetMapping("/user/{id}")
    public Optional getUsersById(Long id){
        Optional user = userEntityService.getUsersById(id);
        return user;
    }

    //   •	Kullanıcı adından kullanıcıyı getiren bir servis yazınız.
    @GetMapping("/userbyname/{name}")
    public List getUsersByUserName(@PathVariable String name){
        List user = userEntityService.getUsersByUserName(name);
        return user;
    }

    //   •	Kullanıcı kaydedilebilecek bir servis yazınız.
    @PostMapping("/user")
    public void saveUser(@RequestBody User user) {
        userEntityService.save(user);
    }

    //   •	Kullanıcı silebilecek bir servis yazınız. (kullanıcı adı, ve telefon bilgileri alınmalı). Eğer kullanıcı adı ve telefon uyuşmuyorsa “XXX kullanıcı adı ile YYY telefonu bilgileri uyuşmamaktadır.” şeklinde bir uyarı vermeil.
    @DeleteMapping("/user/{id}")
    public void deleteUser(@PathVariable Long id){
        userEntityService.deleteUser(id);
    }

    //   •	Kullanıcı bilgilerini güncelleyebilecek bir servis yazınız.
    @PutMapping("/user/{id}")
    public String updateUser(@PathVariable Long id, @RequestBody UserDto userDto) {
        userEntityService.updateUser(id, userDto);
        return "idsi " + id + " olan kullanici bilgileri güncellendi.";
    }



}



