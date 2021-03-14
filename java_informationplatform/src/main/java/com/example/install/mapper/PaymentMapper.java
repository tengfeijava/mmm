package com.example.install.mapper;

import com.example.install.pojo.Payment;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PaymentMapper {
    List<Payment> findBypName(String contract_name);

    void insterPy(Payment payment);

    List<Payment> paymentfind(String contract_name);

    void updatePa(Payment payment);

    void deletePa(int idf);

    Payment paymentfindByName(String contract_name);
}
