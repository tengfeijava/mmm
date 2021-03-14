package com.example.cooperation.mapper;

import com.example.cooperation.pojo.Particulars;
import com.example.index.pojo.Maintain;
import org.apache.ibatis.annotations.Mapper;

import java.lang.reflect.Parameter;
import java.util.List;

@Mapper
public interface ParticularsMapper {
    Particulars ParticularsfindByName(String contract_name);

    Particulars findByName(String contract_name);


    void insertp(Particulars particulars);

    void updatep(Particulars particulars);

    void updateP(Particulars particulars);

    void deletep(int id);

    List<Particulars> selectNumberAndFirm();

    Particulars serviceSum();

    void deleteStr(String contractName);
}
