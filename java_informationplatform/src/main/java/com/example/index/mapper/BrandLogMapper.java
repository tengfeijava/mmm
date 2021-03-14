package com.example.index.mapper;

import com.example.index.pojo.Brandlog;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BrandLogMapper {
    List<Brandlog> selectAllBrandLog();
}
