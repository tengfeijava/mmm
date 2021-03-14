package com.example.index.mapper;


import com.example.index.pojo.Points;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PointsMapper {
    List<Points> findAllName();

}
