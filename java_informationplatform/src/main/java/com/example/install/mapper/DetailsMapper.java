package com.example.install.mapper;

import com.example.install.pojo.Details;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DetailsMapper {


    List<Details> findBydetailsName(String contract_name);

    void insterDe(Details details);

    void updateDe(Details details);

    void deleteDe(int idh);

    Details findByName(String contract_name);




    List<Details> fingByName(String elevatorClass, String keywords);
}
