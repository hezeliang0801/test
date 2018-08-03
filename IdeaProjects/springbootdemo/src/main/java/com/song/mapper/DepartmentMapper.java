package com.song.mapper;

import com.song.entity.Department;
import org.mapstruct.Mapper;

@Mapper
public interface DepartmentMapper {

    public void insert(Department department);
    
    public Department getById(Integer id);
    
    public void update(Department department);
    
    public void deleteById(Integer id);
}