package com.example.index.mapper;

import com.example.index.pojo.Bigbrand;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BigMapper {
    List<Bigbrand> selectName();

}
