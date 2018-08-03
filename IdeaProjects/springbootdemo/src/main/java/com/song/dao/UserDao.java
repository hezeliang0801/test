package com.song.dao;

import com.song.entity.User;
import org.springframework.stereotype.Component;

@Component
public interface UserDao {

    public int insert(User user);
    
    public int deleteById(Integer id);
    
    public int update(User user);
    
    public User getById(Integer id);
}