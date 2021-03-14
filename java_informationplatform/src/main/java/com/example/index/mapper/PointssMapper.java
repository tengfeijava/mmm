package com.example.index.mapper;

import com.example.index.pojo.Pointss;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PointssMapper {
    List<Pointss> findBylng(int id);
}
