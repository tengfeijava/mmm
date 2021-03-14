package com.example.index.mapper;

import com.example.index.pojo.Sell;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SellMapper {
    Sell sellCollect(String sell_class);
}
