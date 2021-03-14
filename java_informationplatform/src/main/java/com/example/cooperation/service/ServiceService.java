package com.example.cooperation.service;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.UploadFileResult;
import com.example.cooperation.mapper.GatheringPaymentMapper;
import com.example.cooperation.mapper.ParticularsMapper;
import com.example.cooperation.mapper.ServiceMapper;
import com.example.cooperation.pojo.Contracts;
import com.example.cooperation.pojo.GatheringPayment;
import com.example.cooperation.pojo.Particulars;
import com.example.cooperation.pojo.ServiceSum;
import com.example.index.pojo.Brandlog;
import com.example.index.pojo.Maintain;
import com.example.index.service.IndexService;
import com.example.install.mapper.SupplierMapper;
import com.example.install.pojo.Contract;
import com.example.install.pojo.Supplier;
import com.example.utils.UplodFile;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Parameter;
import java.math.BigDecimal;
import java.util.*;

import static java.lang.System.in;
import static java.lang.System.setOut;

@Service
public class ServiceService {

    private static String bucket;
    private static String ossAccessId;  // 你的访问AK信息
    private static String ossAccessKey; // 你的访问AK信息
    private static String ossEndpoint;  // 如: http://oss-cn-beijing.aliyuncs.com
    static {
        bucket = "dytz";
        ossAccessId = "LTAI5onE2cPusoWT";
        ossAccessKey = "yPE3D3IbIhQ4JwcGNdz0ON5rLU4Z9P";
        ossEndpoint = "oss-cn-beijing.aliyuncs.com";
    }


    OSSClient ossClient = new OSSClient(ossEndpoint, ossAccessId, ossAccessKey);

    @Resource
    private ServiceMapper serviceMapper;
    @Resource
    private ParticularsMapper particularsMapper;
    @Resource
    private GatheringPaymentMapper gatheringPaymentMapper;

    public void uplodmultipartFile(MultipartFile multipartFile) {

        // String inputStream = service_accessory.getOriginalFilename();
        String substring = multipartFile.getOriginalFilename().substring(multipartFile.getOriginalFilename().lastIndexOf("."));
        String fileName = UUID.randomUUID().toString().replaceAll("-", "") + substring;
        String key = "elevatorinvoice/" + fileName;
        InputStream inputStream = null;
        try {
            inputStream = multipartFile.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("上传有问题");
        }
        ossClient.putObject(bucket, key,inputStream);

        String str = "https://" + bucket + "." + ossEndpoint + "/" +"elevatorinvoice" + "/" + fileName;
        System.out.println("图片路径："+str);
    }


    public PageInfo<Contracts> serviceAll(int pageNum, int pageSize) {
        String name = "维";
        PageHelper.startPage(pageNum,pageSize);
        List<Contracts> list =serviceMapper.serviceAll(name);

        int size = list.size();
        //System.out.println(size);
        for (Contracts contract : list) {
          if (contract != null){
              String endTime = contract.getEndTime().substring(0, 10);
              String startTime = contract.getStartTime().substring(0, 10);
              contract.setStartTime(startTime);
              contract.setEndTime(endTime);
          }
          Particulars particulars = particularsMapper.ParticularsfindByName(contract.getContractName());

 //           List<GatheringPayment> byContract = gatheringPaymentMapper.findByContract(contract.getContractName());
//            if (byContract != null){
//             double sum = 0;
//                for (GatheringPayment gatheringPayment : byContract) {
//                   sum += gatheringPayment.getServiceMoney();
//                }
//                if (sum != 0){
//                    BigDecimal bd = new BigDecimal(sum);
//                   contract.setServiceSum(bd.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
//                }
//            }
            if (particulars != null){
                contract.setServiceNumber(particulars.getServiceNumber());
              contract.setServiceType(particulars.getServiceType());
              contract.setServicePeriod(particulars.getServicePeriod());
              contract.setServiceNumber(particulars.getServiceNumber());
              contract.setCity(particulars.getServiceCity());

          }
        }

      Collections.sort(list, new Comparator<Contracts>() {
          @Override
          public int compare(Contracts contracts, Contracts t1) {
              if (contracts.getServiceNumber() > t1.getServiceNumber()) {
                  return -1;
              }
              if (contracts.getServiceNumber() > t1.getServiceNumber()) {
                  return 0;
              }
              return 1;
          }
      });




        PageInfo<Contracts> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Resource
    private IndexService indexService;

    public Contracts findById(int id) {

        Contracts contracts =  serviceMapper.findById(id);
        String substring = contracts.getStartTime().substring(0, 10);
        String substring1 = contracts.getEndTime().substring(0, 10);
        contracts.setStartTime(substring);
        contracts.setEndTime(substring1);
        Particulars particulars= particularsMapper.findByName(contracts.getContractName());
        if (particulars != null){
            contracts.setServiceNumber(particulars.getServiceNumber());
            contracts.setCity(particulars.getServiceCity());
            contracts.setFirm(particulars.getServiceFirm());
            contracts.setServiceobject(particulars.getServiceObject());
            contracts.setServicePeriod(particulars.getServicePeriod());
            contracts.setServiceType(particulars.getServiceType());
            contracts.setParticulars(particulars);
        }
        List<GatheringPayment> list = gatheringPaymentMapper.findByContract(contracts.getContractName());
        if (list != null){
//            Iterator<GatheringPayment> iterator = list.iterator();
//            if (iterator != null){
//                if (iterator.next() != null){
//                    GatheringPayment next = iterator.next();
//                    contracts.setServiceStartEnd(next.getServiceStartEnd());
//                }
//            }

            //payment 付款 gathering 收款
            ArrayList<GatheringPayment> paymen = new ArrayList<>();
            ArrayList<GatheringPayment> gathering = new ArrayList<>();
            for (GatheringPayment gatheringPayment : list)

                if (gatheringPayment.getServiceClass().equals("PAYMENT")) {
                    contracts.setServiceStartEnd(gatheringPayment.getServiceStartEnd());
                    paymen.add(gatheringPayment);
                } else if (gatheringPayment.getServiceClass().equals("GATHERING")) {
                    gathering.add(gatheringPayment);
                }
//             double paymenSum  = 0;
//                for (GatheringPayment money : paymen) {
//                        paymenSum += money.getServiceMoney();
//                }
//                  if (paymenSum != 0){
//                      particulars.setServicePaymen(paymenSum);
//                  }

              double gatheringSum = 0;
              double paymentSum = 0;
            for (GatheringPayment gatheringPayment : gathering) {
                if (gatheringPayment.getServiceClass().equals("GATHERING")){
                    gatheringSum += gatheringPayment.getServiceMoney();
                }else if (gatheringPayment.getServiceClass().equals("PAYMENT")){
                    paymentSum +=  gatheringPayment.getServiceMoney();
                }
                }
            if (gatheringSum != 0){
                BigDecimal bd = new BigDecimal(gatheringSum);
                 contracts.setGatheringSum(bd.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
                particulars.setServiceGathering(gatheringSum);
            }else if (paymentSum != 0){
                BigDecimal bd = new BigDecimal(paymentSum);
                 contracts.setPaymentSum(bd.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
            }
            contracts.setPaymentList(paymen);
            contracts.setGatheringList(gathering);

        }
        return contracts;
    }


    @Resource
    private UplodFile uplodFile;

    public void insertgp(GatheringPayment gatheringPayment, MultipartFile fileImg) {

        String str = uplodFile.uplodFile(fileImg);
        gatheringPayment.setServiceAccessory(str);
        gatheringPaymentMapper.insertgp(gatheringPayment);


    }




    public void insertp(Particulars particulars) {
        particularsMapper.insertp(particulars);
    }

    public void updategp(GatheringPayment gatheringPayment) {
        gatheringPaymentMapper.updategp(gatheringPayment);
    }

    public void updatep(Particulars particulars) {
        particularsMapper.updatep(particulars);
    }

    public void deletegp(int id) {
        gatheringPaymentMapper.deletegp(id);
    }

    public void deletep(int id) {
        particularsMapper.deletep(id);
    }


    public List<GatheringPayment> searchName(String keywords) {
       return  gatheringPaymentMapper.searchName(keywords);
    }



    public Contracts searchByName(String name) {

       Contracts contracts = serviceMapper.searchByName(name);

        Particulars particulars= particularsMapper.findByName(contracts.getContractName());
        if (particulars != null){
            contracts.setServiceNumber(particulars.getServiceNumber());
            contracts.setCity(particulars.getServiceCity());
            contracts.setFirm(particulars.getServiceFirm());
            contracts.setServiceobject(particulars.getServiceObject());
            contracts.setServicePeriod(particulars.getServicePeriod());
            contracts.setServiceType(particulars.getServiceType());
            contracts.setParticulars(particulars);
        }
        List<GatheringPayment> list = gatheringPaymentMapper.findByContract(contracts.getContractName());
        if (list != null){
            Iterator<GatheringPayment> iterator = list.iterator();
            GatheringPayment next = iterator.next();
            contracts.setServiceStartEnd(next.getServiceStartEnd());
            //payment 付款 gathering 收款
            ArrayList<GatheringPayment> paymen = new ArrayList<>();
            ArrayList<GatheringPayment> gathering = new ArrayList<>();
            for (GatheringPayment gatheringPayment : list)

                if (gatheringPayment.getServiceClass().equals("PAYMENT")) {

                    paymen.add(gatheringPayment);
                } else if (gatheringPayment.getServiceClass().equals("GATHERING")) {
                    gathering.add(gatheringPayment);
                }
//             double paymenSum  = 0;
//                for (GatheringPayment money : paymen) {
//                        paymenSum += money.getServiceMoney();
//                }
//                  if (paymenSum != 0){
//                      particulars.setServicePaymen(paymenSum);
//                  }

            double gatheringSum = 0;
            double paymentSum = 0;
            for (GatheringPayment gatheringPayment : gathering) {
                if (gatheringPayment.getServiceClass().equals("GATHERING")){
                    gatheringSum += gatheringPayment.getServiceMoney();
                }else if (gatheringPayment.getServiceClass().equals("PAYMENT")){
                    paymentSum +=  gatheringPayment.getServiceMoney();
                }
            }
            if (gatheringSum != 0){
                BigDecimal bd = new BigDecimal(gatheringSum);
                contracts.setGatheringSum(bd.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
                particulars.setServiceGathering(gatheringSum);
            }else if (paymentSum != 0){
                BigDecimal bd = new BigDecimal(paymentSum);
                contracts.setPaymentSum(bd.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
            }
            contracts.setPaymentList(paymen);
            contracts.setGatheringList(gathering);

        }
        return contracts;

    }

    public ServiceSum serviceSum() {
        Particulars particulars= particularsMapper.serviceSum();
        ServiceSum serviceSum = new ServiceSum();
        serviceSum.setServiceSum(particulars.getServiceNumber());
        return serviceSum;
    }
    @Resource
    private RedisTemplate redisTemplate;

    public void supplier(Particulars particulars) {
        Particulars byName = particularsMapper.findByName(particulars.getServiceName());

        if (byName == null){
            particularsMapper.insertp(particulars);
        }
        particularsMapper.updateP(particulars);
        redisTemplate.delete("brandList");
    }

//    public void updateSupplier(Particulars particulars) {
//        particularsMapper.updateP(particulars);
//        redisTemplate.delete("brandList");
//    }
//
//    public void deleteSupplier(String contractName) {
//        particularsMapper.deleteStr(contractName);
//    }
}
