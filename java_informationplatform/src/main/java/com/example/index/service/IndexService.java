package com.example.index.service;



import com.alibaba.fastjson.JSON;
import com.example.cooperation.mapper.ParticularsMapper;
import com.example.cooperation.pojo.Particulars;
import com.example.index.mapper.*;
import com.example.index.pojo.*;
import com.example.install.mapper.DetailsMapper;
import com.example.install.mapper.SupplierMapper;
import com.example.install.pojo.Supplier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.*;

@Service
public class IndexService {



    @Resource
    private RedisTemplate redisTemplate;
    @Resource
    private TodoindexMapper todoindexMapper;
    @Resource
    private InstallMapper installMapper;
    @Resource
    private SellMapper sellMapper;
    @Resource
    private MaintainMapper maintainMapper;

    public List<Todoindex> startAll() {
         List<Todoindex> todoindexList = todoindexMapper.findAll();
         return todoindexList;
    }




//    public   Map<String,Object> allaaa() {
////
////        Map<String,Object> map1 =  new HashMap<>();
////
////        List<Object> list = new ArrayList<>();
////        Map<String,List> map2 = new HashMap<>();
////        List<String> brand = todoindexMapper.brandList();
////            for (String s : brand) {
////                map2.put(s,brandMapper.findByidhName(s));
////            }
////           list.add(map2);
////        map1.put("s",list);
////       return map1;
////    }
    @Resource
    private BigMapper bigMapper;
    @Resource
    private BrandMapper brandsMapper;
    public List<Bigbrand> children() {
        List<Bigbrand> bigList1 = (List<Bigbrand>) redisTemplate.opsForValue().get("bigList");
        if (bigList1 != null){
            return bigList1;
        }
        List<Bigbrand> bigList = bigMapper.selectName();
        for (Bigbrand big : bigList) {
            List<Brands> brands = brandsMapper.selectBrand(big.getName());
            big.setChildren(brands);
        }
       redisTemplate.opsForValue().set("bigList",bigList);
        return bigList;
    }



    public Install installCollect() {
//        Install install1 = (Install) redisTemplate.opsForValue().get("install");
//        if (install1 != null){
//            return install1;
//        }
        String elevator_class = "PROGRAMME";
        Install install = installMapper.installCollect(elevator_class);
        BigDecimal bigDecimal = new BigDecimal(String.valueOf(install.getInstallincome()));
        BigDecimal bigDecima2 = new BigDecimal(String.valueOf(install.getInstallexpend()));
        BigDecimal subtract = bigDecima2.subtract(bigDecimal);
        install.setInstallexpend(subtract);
    //    redisTemplate.opsForValue().set("install",install);
        return install;
    }

    public Sell sellCollect() {

//        Sell sell1 = (Sell) redisTemplate.opsForValue().get("sell");
//        if (sell1 != null){
//            return sell1;
//        }

        String sell_class = "PURCHASE";
        Sell sell = sellMapper.sellCollect(sell_class);
        if (sell != null){
            BigDecimal bigDecimal = new BigDecimal(String.valueOf(sell.getSellIncome()));
            BigDecimal bigDecima2 = new BigDecimal(String.valueOf(sell.getSellExpend()));
            BigDecimal subtract = bigDecima2.subtract(bigDecimal);
            sell.setSellExpend(subtract);
        }
   //     redisTemplate.opsForValue().set("sell",sell);
        return sell;
    }
    public Maintain maintainCollect() {
        Maintain maintain = new Maintain();
        int Numbersum =  maintainMapper.findByNumbersum();
        if (Numbersum != 0){
            maintain.setMaintainsum(Numbersum);
        }

        double gathering =   maintainMapper.findBygathering("GATHERING");
        if(gathering != 0){
            maintain.setMaintainincome(gathering);
        }
       double payment = maintainMapper.findBypaymen("PAYMENT");
        if (payment != 0){
           maintain.setMaintainexpend(payment);
       }
       return maintain;
    }
    public void updeteIndex(Todoindex todoindex) {
        todoindexMapper.updeteIndex(todoindex);
    }

    public void deletelIndex(int id) {
        todoindexMapper.deletelIndex(id);
    }

    public void insertIndex(Todoindex todoindex) {
        todoindexMapper.insertIndex(todoindex);
    }


    public void arrdelete(List<Integer> list) {
        todoindexMapper.arrdelete(list);
    }


    @Resource
    private PointsMapper pointsMapper;
    @Resource
    private PointssMapper pointssMapper;

    public List<Points> pointsAll() {
     //   List<Points> pointsList = (List<Points>) redisTemplate.opsForValue().get("points");
      //  if (pointsList != null){
         //   return pointsList;
      //  }
       List<Points> points = pointsMapper.findAllName();
        for (Points point : points) {
            point.setLocation(pointssMapper.findBylng(point.getId()));
        }
      //  redisTemplate.opsForValue().set("points",points);
        return points;
    }

    @Resource
    private BrandLogMapper brandLogMapper;
    @Resource
    private DetailsMapper detailsMapper;
    @Resource
    private SupplierMapper supplierMapper;
    @Resource
    private InstallDetailsMapper installDetailsMapper;



    public List<Brandlog> sellBrand() {
        List<Brandlog> list = (List<Brandlog>) redisTemplate.opsForValue().get("brandList");
        if (list != null){
            return list;
        }
        String str = "PURCHASE";
        List<Brandlog> brandLOGList = brandLogMapper.selectAllBrandLog();

        List<InstallDetails> detailsList = installDetailsMapper.selectList(str);
        for (Brandlog brandlog : brandLOGList) {
            int sum = 0;
            for (InstallDetails details : detailsList) {
                Supplier supplier = supplierMapper.supplierGetName(details.getContractname());
                if (supplier != null){
                    if (brandlog.getBrand().equals(supplier.getBrand())){
                        sum += details.getCount();
                        brandlog.setBrandNumber(sum);
                    }
                }
            }
        }
        Collections.sort(brandLOGList, new Comparator<Brandlog>() {

            public int compare(Brandlog b1, Brandlog b2) {

                // 按照学生的年龄进行降序排列
                if (b1.getBrandNumber() > b2.getBrandNumber()) {
                    return -1;
                }
                if (b1.getBrandNumber() == b2.getBrandNumber()) {
                    return 0;
                }
                return 1;
            }
        });
        Iterator<Brandlog> iterator = brandLOGList.iterator();
        while (iterator.hasNext()){
            Brandlog next = iterator.next();
            if (next.getBrandNumber() == 0){
                iterator.remove();
            }
        }


        redisTemplate.opsForValue().set("brandList",brandLOGList);
        return brandLOGList;
    }



        @Resource
    private ParticularsMapper particularsMapper;

    public List<Brandlog> maintainBrand() {

        List<Brandlog> brandList = (List<Brandlog>) redisTemplate.opsForValue().get("brandLogsList");
        if (brandList != null){
            return brandList;
        }

        List<Brandlog> brandLogsList = brandLogMapper.selectAllBrandLog();
        List<Particulars> particularsList = particularsMapper.selectNumberAndFirm();


        for (Brandlog brandlog : brandLogsList) {
            for (Particulars particulars : particularsList) {
                if (brandlog.getBrand().equals(particulars.getServiceFirm())){
                    int serviceNumber = particulars.getServiceNumber();
                    brandlog.setBrandNumber(serviceNumber);
                    }
                }
            }
        Collections.sort(brandLogsList, new Comparator<Brandlog>() {

            public int compare(Brandlog u1, Brandlog u2) {


                if (u1.getBrandNumber() > u2.getBrandNumber()) {
                    return -1;
                }
                if (u1.getBrandNumber() == u2.getBrandNumber()) {
                    return 0;
                }
                return 1;
            }
        });
        Iterator<Brandlog> iterator = brandLogsList.iterator();
        while (iterator.hasNext()){
            Brandlog next = iterator.next();
            if (next.getBrandNumber() == 0){
                iterator.remove();
            }
        }
        redisTemplate.opsForValue().set("brandLogsList",brandLogsList);
        return brandLogsList;
    }
}
