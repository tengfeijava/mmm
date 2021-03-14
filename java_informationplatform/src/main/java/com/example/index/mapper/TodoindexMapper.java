package com.example.index.mapper;

import com.example.index.pojo.Todoindex;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TodoindexMapper {
    List<String> brandList();

    List<Todoindex> findAll();


    void updeteIndex(Todoindex todoindex);

    void deletelIndex(int id);

    void insertIndex(Todoindex todoindex);


    void arrdelete(List<Integer> list);
}
