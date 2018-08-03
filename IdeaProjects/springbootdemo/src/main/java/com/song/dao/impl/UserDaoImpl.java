package com.song.dao.impl;

import com.song.dao.UserDao;
import com.song.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
@Component
public class UserDaoImpl implements UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    @Override
    public int insert(User user) {
        String sql = "insert into tbl_user(id,name,password,birthday) values(?,?,?,?)";
        return this.jdbcTemplate.update(
                          sql,
                          user.getId(),
                          user.getName(),
                          user.getPassword(),
                          user.getBirthday()
                                        );
    }

    @Override
    public int deleteById(Integer id) {
        String sql = "delete from tbl_user where id = ?";
        return this.jdbcTemplate.update(sql,id);
    }

    @Override
    public int update(User user) {
        String sql = "update tbl_user set password = ? where id = ?";
        return this.jdbcTemplate.update(
                                sql, 
                                user.getPassword(),
                                user.getId()
                                        );
    }

    @Override
    public User getById(Integer id) {
        String sql = "select * from tbl_user where id = ?";
        return this.jdbcTemplate.queryForObject(sql, new RowMapper<User>() {

            @Override
            public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setPassword(rs.getString("password"));
                user.setBirthday(rs.getDate("birthday"));
                return user;
            }
            
        },id);
    }

}