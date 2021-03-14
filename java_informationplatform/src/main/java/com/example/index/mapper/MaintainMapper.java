package com.example.index.mapper;

import com.example.index.pojo.Maintain;
import org.apache.ibatis.annotations.Mapper;

import java.math.BigDecimal;

@Mapper
public interface MaintainMapper {

    int findByNumbersum();

    double findBygathering(String gathering);

    double findBypaymen(String payment);
}
