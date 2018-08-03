package com.song.test;

import com.song.configuration.Entry;
import com.song.dao.UserDao;
import com.song.entity.Department;
import com.song.mapper.DepartmentMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Entry.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@EnableAutoConfiguration
public class DepartmentTest {

    @Autowired
    private DepartmentMapper departmentMapper;

    @Autowired
    private UserDao userDao;

    @Test
    public void testInsert() {
        Department department = new Department();
        department.setId(2);
        department.setName("生产部");
        department.setDescr("生产产品");
        this.departmentMapper.insert(department);
    }
    
    @Test
    public void testGetById() {
        Department department = this.departmentMapper.getById(1);
        System.out.println(department);
    }
    
    @Test
    public void testUpdate() {
        Department department = new Department();
        department.setId(1);
        department.setDescr("开发高级产品");
        this.departmentMapper.update(department);
    }
    
    @Test
    public void testDeleteById() {
        this.departmentMapper.deleteById(1);
    }

    @Test
    public void testSet(){
       Date date1 =  new Date();
       Long date2 = date1.getTime();
       System.out.println(date2/(1000*60));

    }
}