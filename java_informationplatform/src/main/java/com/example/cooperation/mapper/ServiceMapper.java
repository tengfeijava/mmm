package com.example.cooperation.mapper;

import com.example.cooperation.pojo.Contracts;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ServiceMapper {
    List<Contracts> serviceAll(String name);

    Contracts findById(int id);

    Contracts searchByName(String name);
}
