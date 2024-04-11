package AISS.VimeoMiner.service;

import AISS.VimeoMiner.model.vimeo.comment.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceTest {

    @Autowired
    UserService userService;

    @Test
    @DisplayName("Get an specific user")
    void getUser(){
        User user= userService.getUser("11107993");
        System.out.println(user);
    }

}