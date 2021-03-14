package com.example.install.service;

import com.example.index.mapper.InstallMapper;
import com.example.index.pojo.Install;
import com.example.install.pojo.SellSum;
import com.example.index.service.IndexService;
import com.example.install.mapper.*;
import com.example.install.pojo.*;
import com.example.utils.UplodFile;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;

@Service
public class SellService {



    @Resource
    private ContractMapper contractMapper;
    @Resource
    private DetailsMapper detailsMapper;
    @Resource
    private AccountMapper accountMapper;
    @Resource
    private PaymentMapper paymentMapper;
    @Resource
    private InvoiceMapper invoiceMapper;
    @Resource
    private InstallService installService;
    @Resource
    private SupplierMapper supplierMapper;


    public PageInfo<Contract> sellfy(int pageNum, int pageSize) {
        String contractclass = "PURCHASE";
        PageHelper.startPage(pageNum,pageSize);

        List<Contract> contractList = contractMapper.contractfind(contractclass);
        for (Contract contract : contractList) {
                String substring = contract.getSign_date().substring(0,4);
                contract.setSign_date(substring);

            Details details =  detailsMapper.findByName(contract.getContract_name());
            Payment payment = paymentMapper.paymentfindByName(contract.getContract_name());
            Supplier supplier = supplierMapper.supplierGetName(contract.getContract_name());
            if (supplier != null){
                contract.setBrands(supplier.getBrand());
                contract.setCityd(supplier.getCity());
                contract.setSupplier_name(supplier.getSupplierName());
            }
            if (details != null ){
                contract.setCounts(details.getCount());
                if (payment != null){
                    contract.setCounts(details.getCount() + payment.getFcount());
                }
            }

            }

            PageInfo<Contract> pageInfo = new PageInfo<>(contractList);

            return pageInfo;
        }


    @Resource
    private UplodFile uplodFile;

    public void insterDe(MultipartFile sellImgDe, Details details) {
        String str = uplodFile.uplodFileImg(sellImgDe);
        details.setDeAccessory(str);
        details.setElevatorclass("PURCHASE");
        detailsMapper.insterDe(details);
    }

    public void insterPy(MultipartFile sellImgaPa,Payment payment) {
        String str = uplodFile.uplodFileImg(sellImgaPa);
        payment.setfAccessory(str);
        payment.setFelevatorclass("PURCHASE");
        paymentMapper.insterPy(payment);
    }


    @Resource
    private IndexService indexService;
    @Resource
    private InstallMapper installMapper;


    public Contract sellFindByid(String id){
     //   Sell sell = indexService.sellCollect();
//        String elevator_class = "PURCHASE";
//        Install install = installMapper.instaSum(elevator_class);
        Contract contract = installService.contractFindBiId(id);
//        Account account = contract.getAccount();
//        account.setSellSum(install.getInstallsum());
//        account.setSellIncome(install.getInstallincome());
//        account.setSellExpend(install.getInstallexpend());
        return contract;
    }


    public List<Details> searchName(String keywords) {
        String elevatorClass = "PURCHASE";
        List<Details> detailsList = detailsMapper.fingByName(elevatorClass,keywords);
        return detailsList;
    }

    public Contract searchByName(String name) {
     //   Sell sell = indexService.sellCollect();
        Contract contract = contractFindByName(name);
       // Account account = contract.getAccount();
//        account.setSellSum(sell.getSellsum());
//        account.setSellIncome(sell.getSellincome());
//        account.setSellExpend(sell.getSellexpend());
        return contract;
    }
    public Contract contractFindByName(String name){
        Contract contract = contractMapper.searchByName(name);
        String substring = contract.getSign_date().substring(0, 10);
        contract.setSign_date(substring);
        Account accountL = new Account();
        Account account= accountMapper.findByName(contract.getContract_name());
        accountL.setSignDate(contract.getSign_date());
        accountL.setContractName(contract.getContract_name());
        if (account != null){
            accountL.setAmountSum(account.getAmountSum());
            accountL.setAmountActual(account.getAmountActual());
        }

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

    public SellSum instaSum() {

        SellSum sellSum = new SellSum();
        String elevator_class = "PURCHASE";
        Install install = installMapper.instaSum(elevator_class);
        sellSum.setSellexpend(install.getInstallexpend());
        sellSum.setSellincome(install.getInstallincome());
        sellSum.setSellsum(install.getInstallsum());
        return sellSum;
    }
}

