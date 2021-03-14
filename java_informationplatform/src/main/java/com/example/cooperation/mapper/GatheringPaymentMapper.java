package com.example.cooperation.mapper;

import com.example.cooperation.pojo.Contracts;
import com.example.cooperation.pojo.GatheringPayment;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GatheringPaymentMapper {
    List<GatheringPayment> findByContract(String contract_name);


    void insertgp(GatheringPayment gatheringPayment);

    void updategp(GatheringPayment gatheringPayment);

    void deletegp(int id);

    List<GatheringPayment> searchName(String keywords);
}
