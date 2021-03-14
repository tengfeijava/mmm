package com.example.install.controller;

import com.example.install.pojo.*;
import com.example.install.service.InstallService;
import com.example.install.service.SellService;
import com.example.utils.Result;
import com.example.utils.StatusCode;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/sell")
public class SellController {

    @Resource
    private SellService sellService;
    @Resource
    private InstallService installService;

    @RequestMapping(value = "/searchName",method = RequestMethod.GET)
    public Result searchName(@RequestParam(name = "keywords") String keywords){
        List<Details> detailsList = sellService.searchName(keywords);
        return new Result(true,StatusCode.OK,"成功",detailsList);
    }
   @RequestMapping(value = "/searchByName",method = RequestMethod.GET)
   public Result searchByName(@RequestParam(name = "name") String name){
       Contract contract = sellService.searchByName(name);
       return new Result(true, StatusCode.OK,"ok",contract);
   }
    @RequestMapping(value = "/sellfy/{pageNum}/{pageSize}",method = RequestMethod.GET)
    public Result sellfy(@PathVariable int pageNum,@PathVariable int pageSize){
        PageInfo<Contract> page = sellService.sellfy(pageNum,pageSize);
        SellSum sell = sellService.instaSum();
        return new Result(true, StatusCode.OK,"ok",page, sell);
     }
    @RequestMapping(value = "/findByid/{id}",method = RequestMethod.GET)
    public Result findByid(@PathVariable String id){
        Contract contractp = sellService.sellFindByid(id);
        return new Result(true,StatusCode.OK,"ok",contractp);
    }
    //收款电梯和付款电梯
    @RequestMapping(value = "/insterDe",method = RequestMethod.POST)
    public Result insterDe(@RequestParam("sellImgDe") MultipartFile sellImgDe, Details details){
        sellService.insterDe(sellImgDe,details);
        return new Result(true,StatusCode.OK,"ok");
    }
    @RequestMapping(value = "/insterPa",method = RequestMethod.POST)
    public Result insterPy(@RequestParam("sellImgaPa") MultipartFile sellImgaPa, Payment payment){
        sellService.insterPy(sellImgaPa,payment);
        return new Result(true,StatusCode.OK,"ok");
    }
    @RequestMapping(value = "/updateDe",method = RequestMethod.POST)
    public Result updateDe(@RequestBody Details details){
        installService.updateDe(details);
        return new Result(true,StatusCode.OK,"ok");
    }
    @RequestMapping(value = "/updatePa",method = RequestMethod.POST)
    public Result updatePa(@RequestBody Payment payment){
        installService.updatePa(payment);
        return new Result(true,StatusCode.OK,"ok");
    }
    @RequestMapping(value = "/deleteDe/{idh}",method = RequestMethod.GET)
    public Result deleteDe(@PathVariable int idh){
        installService.deleteDe(idh);
        return new Result(true,StatusCode.OK,"ok");
    }
    @RequestMapping(value = "/deletePa/{idf}",method = RequestMethod.GET)
    public Result deletePa(@PathVariable int idf){
        installService.deletePa(idf);
        return new Result(true,StatusCode.OK,"ok");
    }

    @RequestMapping(value = "/supplier",method = RequestMethod.POST)
    public Result suppluer(@RequestBody Supplier supplier){
        installService.supplier(supplier);
        return new Result(true,StatusCode.OK,"ok");
    }
//    @RequestMapping(value = "/updatesupplier",method = RequestMethod.POST)
//    public Result updatesupplier(@RequestBody Supplier supplier){
//        installService.updateSupplier(supplier);
//        return new Result(true,StatusCode.OK,"ok");
//    }
    @RequestMapping(value = "/deletesupplier",method = RequestMethod.GET)
    public Result deletesupplier(@RequestParam(name = "contractName") String contractName){
        installService.deleteSupplier(contractName);
        return new Result(true,StatusCode.OK,"ok");
    }
}
