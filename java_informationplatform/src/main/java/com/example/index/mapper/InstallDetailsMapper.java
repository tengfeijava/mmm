package com.example.index.mapper;

import com.example.index.pojo.InstallDetails;
import com.example.install.pojo.Details;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface InstallDetailsMapper {

    List<InstallDetails> selectPurchase(String str);

    List<InstallDetails> selectList(String str);
}
