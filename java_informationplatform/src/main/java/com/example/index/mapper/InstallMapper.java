package com.example.index.mapper;

import com.example.index.pojo.Install;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface InstallMapper {
    Install installCollect(String elevator_class);

    Install instaSum(String elevator_class);

}
