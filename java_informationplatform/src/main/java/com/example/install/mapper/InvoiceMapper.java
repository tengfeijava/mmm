package com.example.install.mapper;

import com.example.install.pojo.Invoice;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface InvoiceMapper {
    List<Invoice> findByiName(String contract_name);

    void deleteByid(int id);

    void insertByInvoice(Invoice invoice);

    void UpdateByInvoice(Invoice invoice);
}
