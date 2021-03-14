package com.example.install.mapper;

import com.example.install.pojo.Account;
import com.example.index.pojo.Install;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AccountMapper {
    List<Install> selectfyAll();

    Account findByName(String contract_name);
}
