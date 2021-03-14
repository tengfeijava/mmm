package com.example.install.mapper;


import com.example.install.pojo.Contract;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ContractMapper {
    List<Contract> contractfind(String contractclass);

    Contract findByid(String id);


    Contract searchByName(String name);

    void deleteCheck(String dateCheck);
}
