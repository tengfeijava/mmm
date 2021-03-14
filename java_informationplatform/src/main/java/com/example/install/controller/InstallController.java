package com.example.install.controller;


import com.example.index.pojo.Install;
import com.example.install.pojo.*;
import com.example.install.service.InstallService;
import com.example.utils.Result;
import com.example.utils.StatusCode;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/install")
public class InstallController {

    @Resource
    private InstallService installService;


   @RequestMapping(value = "/fy/{pageNum}/{pageSize}",method = RequestMethod.GET)
    public Result fy(@RequestParam(value = "pageNum",defaultValue = "1") int pageNum,@PathVariable int pageSize){
       PageInfo<Install> list = installService.fy(pageNum,pageSize);
       return new Result(true,StatusCode.OK,"ok",list);
   }

    @RequestMapping(value = "/installfy/{pageNum}/{pageSize}",method = RequestMethod.GET)
    public Result installfy(@PathVariable int pageNum,@PathVariable int pageSize){
        PageInfo<Contract> list = installService.installfy(pageNum,pageSize);
        InstallSum installSum = installService.installSum();

        return new Result(true,StatusCode.OK,"ok",list,installSum);
    }

    @RequestMapping(value = "/findByid/{id}",method = RequestMethod.GET)
    public Result findByid(@PathVariable String id){//@RequestBody Contract contract
       Contract contractp = installService.findByid(id);//contract.getId()
        return new Result(true,StatusCode.OK,"ok",contractp);
    }

    @RequestMapping(value = "/searchName",method = RequestMethod.GET)
    public Result searchName(@RequestParam(name = "keywords") String keywords){
        List<Details> detailsList = installService.searchName(keywords);
        return new Result(true,StatusCode.OK,"成功",detailsList);
    }
    @RequestMapping(value = "/searchByName",method = RequestMethod.GET)
    public Result searchByName(@RequestParam(name = "name") String name){
        Contract contract = installService.searchByName(name);
        return new Result(true, StatusCode.OK,"ok",contract);
    }

   //收款电梯和付款电梯
    @RequestMapping(value = "/insterDe",method = RequestMethod.POST)
    public Result insterDe(@RequestParam("fileDe") MultipartFile fileDe, Details details){
        installService.insterDe(fileDe,details);
        return new Result(true,StatusCode.OK,"ok");
    }
    @RequestMapping(value = "/insterPa",method = RequestMethod.POST)
    public Result insterPy(@RequestParam("filePa") MultipartFile filePa, Payment payment){
        installService.insterPy(filePa,payment);
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
    //发票联系人修改
    @RequestMapping(value = "/updeteByid",method = RequestMethod.POST)
    public Result updeteByid(@RequestBody Invoice invoice){
        installService.updeteByid(invoice);
        return new Result(true,StatusCode.OK,"ok");
    }
    //发票联系人
    @RequestMapping(value = "/inster",method = RequestMethod.POST)
    public Result inster(@RequestBody Invoice invoice){
        installService.inster(invoice);
        return new Result(true,StatusCode.OK,"ok");
    }
    //发票联系人修改
    @RequestMapping(value = "/delete/{id}",method = RequestMethod.GET)
    public Result delete(@PathVariable int id){
        installService.delete(id);
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


