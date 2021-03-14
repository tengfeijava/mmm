package com.example.index.mapper;

import com.example.index.pojo.Brands;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BrandMapper {
    List<Brands> selectBrand(String name);
}
