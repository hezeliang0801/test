package com.song.test;


import com.song.configuration.Entry;
import com.song.dao.UserDao;
import com.song.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Entry.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@EnableAutoConfiguration
public class UserDaoTest {

    @Autowired
    private UserDao userDao;


    @Test
    public void testInsert() {
        User user = new User();
        user.setId(2);
        user.setName("张三");
        user.setPassword("zhangsan");
        user.setBirthday(new Date());
        
        int result = this.userDao.insert(user);
        System.out.println(result);
        System.out.println("test");
    }
    
    @Test
    public void testGetById() {
        User user = this.userDao.getById(1);
        System.out.println(user.getName());
    }
    
    @Test
    public void testUpdate() {
        User user = new User();
        user.setId(1);
        user.setPassword("zhangsan123");
        this.userDao.update(user);
    }
    
    @Test
    public void testDeleteById() {
        int result = this.userDao.deleteById(1);
        System.out.println(result);
    }
}