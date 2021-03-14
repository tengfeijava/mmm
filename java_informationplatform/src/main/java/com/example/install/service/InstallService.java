package com.example.install.service;


import com.example.index.mapper.InstallMapper;
import com.example.index.pojo.Install;
import com.example.index.service.IndexService;
import com.example.install.mapper.*;
import com.example.install.pojo.*;
import com.example.utils.UplodFile;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;

@Service
public class InstallService {


    @Resource
    private AccountMapper accountMapper;
    @Resource
    private ContractMapper contractMapper;
    @Resource
    private DetailsMapper detailsMapper;
    @Resource
    private PaymentMapper paymentMapper;
    @Resource
    private InvoiceMapper invoiceMapper;
    @Resource
    private SupplierMapper supplierMapper;



    public PageInfo<Install> fy(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Install> list = accountMapper.selectfyAll();
        PageInfo<Install> installPageInfo = new PageInfo<>(list);
        return installPageInfo;
    }

    public PageInfo<Contract> installfy(int pageNum, int pageSize) {


        String contractclass = "PROGRAMME";
        PageHelper.startPage(pageNum,pageSize);


        List<Contract> contractList = contractMapper.contractfind(contractclass);
        if (contractList != null){
        for (Contract contract : contractList) {
            if (contract.getSign_date() != null){
                String substring = contract.getSign_date().substring(0,4);
                contract.setSign_date(substring);
            }
            Details details =  detailsMapper.findByName(contract.getContract_name());
            Payment payment = paymentMapper.paymentfindByName(contract.getContract_name());
            Supplier supplier = supplierMapper.supplierGetName(contract.getContract_name());
            if (supplier != null){
                contract.setBrands(supplier.getBrand());
                contract.setCityd(supplier.getCity());
                contract.setSupplier_name(supplier.getSupplierName());
            }
            if (details != null ) {

                contract.setCounts(details.getCount());
                // }
                if (payment != null) {
                    String count = details.getCount() + "";
                    String fcount = payment.getFcount() + "";
                    if ("".equals(count) && "".equals(fcount)) {

                        contract.setCounts(details.getCount() + payment.getFcount());
                    }

                }
            } //
        }
        }



        PageInfo<Contract> installaPageInfo = new PageInfo<>(contractList);
        return installaPageInfo;
    }




    @Resource
    private InstallMapper installMapper;

    public Contract findByid(String id) {

        Contract contract = contractFindBiId(id);



        return contract;
    }

    public Contract contractFindBiId(String id){
        Contract contract = contractMapper.findByid(id);
        String substring = contract.getSign_date().substring(0, 10);
        contract.setSign_date(substring);
        Account accountL = new Account();
    //    Account account= accountMapper.findByName(contract.getContract_name());
        accountL.setSignDate(contract.getSign_date());

        accountL.setContractName(contract.getContract_name());
//        if (account != null){
//            accountL.setAmountSum(account.getAmountSum());
//            accountL.setAmountActual(account.getAmountActual());
//        }

        Supplier supplier = supplierMapper.supplierGetName(contract.getContract_name());
        if (supplier != null){
            accountL.setCity(supplier.getCity());
            accountL.setSupplier(supplier.getSupplierName());
            accountL.setContractCompany(supplier.getBrand());
        }

        List<Details> details = detailsMapper.findBydetailsName(contract.getContract_name());
        if (details != null){
            double proceedsSum = 0;
            double proceedsActual = 0;

            for (Details detail : details) {
                proceedsSum +=  detail.getPrice();
                proceedsActual += detail.getReturnedmoney();

                accountL.setElevatorCount(detail.getCount());


                Double aDouble = Double.valueOf(detail.getReturnedmoney());
                Double aDouble1 = Double.valueOf(detail.getPrice());
                if (aDouble1 != 0.0 && aDouble1 != 0.0){
                    double len = aDouble / aDouble1 * 100;
                    BigDecimal bigDecimal = new BigDecimal(len);
                    detail.setHratio(bigDecimal.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue());
                }
            }
            if (proceedsSum != 0){
                BigDecimal bd = new BigDecimal(proceedsSum);
                accountL.setProceedsSum(bd.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
            }
            if (proceedsActual != 0){
                BigDecimal bd2 = new BigDecimal(proceedsActual);
                accountL.setProceedsActual(bd2.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue());
            }

            contract.setDetailsList(details);
        }
        List<Payment> payments = paymentMapper.findBypName(contract.getContract_name());
        if (payments != null){
            int amountSum = 0;
            int amountActual = 0;
            for (Payment payment : payments) {
                amountSum +=  payment.getFprice();
                amountActual += payment.getFpayment();

                accountL.setElevatorCount(payment.getFcount());


                Double aDouble = Double.valueOf(payment.getFpayment());
                Double aDouble1 = Double.valueOf(payment.getFprice());
                if (aDouble1 != 0.0 && aDouble1 != 0.0){
                    double len = aDouble / aDouble1 * 100;
                    BigDecimal bigDecimal = new BigDecimal(len);
                    payment.setFratio(bigDecimal.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue());
                }
            }
            if (amountSum != 0){
                BigDecimal bd = new BigDecimal(amountSum);
                accountL.setAmountSum(bd.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
            }
            if (amountActual != 0){
                BigDecimal bd2 = new BigDecimal(amountActual);
                accountL.setAmountActual(bd2.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue());
            }
        }
        if (payments != null){
            for (Payment payment : payments) {
                Double aDouble = Double.valueOf(payment.getFprice());
                Double aDouble1 = Double.valueOf(payment.getFpayment());
                if (aDouble != 0.0 && aDouble1 != 0.0 ){
                    double lenn = aDouble / aDouble1 * 100;
                    BigDecimal bigDecimal = new BigDecimal(lenn);
                    payment.setFratio(bigDecimal.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue());
                }

            }
            contract.setPaymentList(payments);

        }
        contract.setAccount(accountL);
        List<Invoice> invoices = invoiceMapper.findByiName(contract.getContract_name());
        if (invoices != null){
            contract.setInvoiceList(invoices);
        }
        return contract;
    }

    public void updeteByid(Invoice invoice) {
        invoiceMapper.UpdateByInvoice(invoice);
    }

    public void inster(Invoice invoice) {
        invoiceMapper.insertByInvoice(invoice);
    }

    public void delete(int id) {
        invoiceMapper.deleteByid(id);
    }



    @Resource
    private UplodFile uplodFile;

    public void insterDe(MultipartFile fileDe, Details details) {

        String str = uplodFile.uplodFileImg(fileDe);
        details.setDeAccessory(str);
        details.setElevatorclass("PROGRAMME");
        detailsMapper.insterDe(details);
    }

    public void insterPy(MultipartFile filePa,Payment payment) {

        String str = uplodFile.uplodFileImg(filePa);
        payment.setfAccessory(str);
        payment.setFelevatorclass("PROGRAMME");
        paymentMapper.insterPy(payment);
    }

    public void updateDe(Details details) {
        detailsMapper.updateDe(details);
    }

    public void updatePa(Payment payment) {
        paymentMapper.updatePa(payment);
    }

    public void deleteDe(int idh) {
        detailsMapper.deleteDe(idh);
    }

    public void deletePa(int idf) {
        paymentMapper.deletePa(idf);
    }

    public List<Details> searchName(String keywords) {
        String elevatorClass = "PROGRAMME";
        List<Details> detailsList = detailsMapper.fingByName(elevatorClass,keywords);
        return detailsList;
    }
    @Resource
    private SellService sellService;

    public Contract searchByName(String name) {
      //  Install install = indexService.installCollect();
        Contract contract = sellService.searchByName(name);
//        Account account = contract.getAccount();
//        account.setInstallSum(install.getInstallsum());
//        account.setInstallIncome(install.getInstallincome());
//        account.setInstallExpend(install.getInstallexpend());
        return contract;
    }

    public InstallSum installSum() {
        String elevator_class = "PROGRAMME";
        Install inst = installMapper.instaSum(elevator_class);
        InstallSum installSum = new InstallSum();
        installSum.setInstallSum(inst.getInstallsum());
        installSum.setInstallExpend(inst.getInstallexpend());
        installSum.setInstallIncome(inst.getInstallincome());
        return installSum;
    }


    @Resource
    private RedisTemplate redisTemplate;

    public void supplier(Supplier supplier) {
       Supplier sup =  supplierMapper.getByNmae(supplier.getContractName());
        if (sup != null){
            supplierMapper.delteSupplier(sup.getContractName());
            supplierMapper.insterSupplier(supplier);
        }else {
            supplierMapper.insterSupplier(supplier);
        }
        redisTemplate.delete("brandList");

    }

//    public void updateSupplier(Supplier supplier) {
//        supplierMapper.updateSupplier(supplier);
//        redisTemplate.delete("brandList");
//
//    }

    public void deleteSupplier(String contractName) {
        supplierMapper.deleteSupplier(contractName);
        redisTemplate.delete("brandList");

    }
}
