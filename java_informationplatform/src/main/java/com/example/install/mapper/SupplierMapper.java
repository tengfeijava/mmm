package com.example.install.mapper;

import com.example.install.pojo.Supplier;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SupplierMapper {
    Supplier supplierGetName(String contract_name);

    void insterSupplier(Supplier supplier);

    void updateSupplier(Supplier supplier);

    void deleteSupplier(String contractName);

    Supplier getByNmae(String contractName);

    void delteSupplier(String contractName);
}
