package com.example.cooperation.controller;

import com.example.cooperation.pojo.Contracts;
import com.example.cooperation.pojo.GatheringPayment;
import com.example.cooperation.pojo.Particulars;
import com.example.cooperation.pojo.ServiceSum;
import com.example.cooperation.service.ServiceService;

import com.example.install.pojo.Supplier;
import com.example.utils.Result;
import com.example.utils.StatusCode;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import javax.annotation.Resource;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/service")
public class ServiceController {


    @Resource
    private ServiceService serviceService;




    @RequestMapping(value = "/serviceAll/{pageNum}/{pageSize}",method = RequestMethod.GET)
    public Result serviceAll(@PathVariable int pageNum,@PathVariable int pageSize){

        PageInfo<Contracts> contract = serviceService.serviceAll(pageNum,pageSize);
        ServiceSum serviceSum = serviceService.serviceSum();
        return new Result(true, StatusCode.OK,"ok",contract,serviceSum);
    }

    @RequestMapping(value = "/findByid/{id}",method = RequestMethod.GET)
    public Result findByid(@PathVariable int id){
        Contracts contracts = serviceService.findById(id);
        return new Result(true,StatusCode.OK,"ok",contracts);
    }

    @RequestMapping(value = "/searchName",method = RequestMethod.GET)
    public Result searchName(@RequestParam(name = "keywords")  String keywords){
       List<GatheringPayment> contracts = serviceService.searchName(keywords);
        return new Result(true,StatusCode.OK,"ok",contracts);
    }
    @RequestMapping(value = "/searchByName",method = RequestMethod.GET)
    public Result searchByName(@RequestParam(name = "name")  String name){
        Contracts contracts = serviceService.searchByName(name);
        return new Result(true,StatusCode.OK,"ok",contracts);
    }



    @RequestMapping(value = "/uplodmultipartFile",method = RequestMethod.POST)
    public Result uplodmultipartFile(@RequestParam("multipartFile")MultipartFile multipartFile){
        serviceService.uplodmultipartFile(multipartFile);
        return new Result(true,StatusCode.OK,"ok");
    }

    @RequestMapping(value = "/insertGp",method = RequestMethod.POST)//,produces = "application/json; charset=utf-8"
    public Result insertGp(@RequestParam("fileImg")MultipartFile fileImg, GatheringPayment gatheringPayment){
        serviceService.insertgp(gatheringPayment,fileImg);
        return new Result(true,StatusCode.OK,"ok");
    }
    @RequestMapping(value = "/insertP",method = RequestMethod.POST)
    public Result insertP(@RequestBody Particulars particulars){
        serviceService.insertp(particulars);
        return new Result(true,StatusCode.OK,"ok");
    }
    @RequestMapping(value = "/updategp",method = RequestMethod.POST)
    public Result updatege(@RequestBody GatheringPayment gatheringPayment){
        serviceService.updategp(gatheringPayment);
        return new Result(true,StatusCode.OK,"ok");
    }
   @RequestMapping(value = "/updateP",method = RequestMethod.POST)
    public Result updateP(@RequestBody Particulars particulars){
        serviceService.updatep(particulars);
        return new Result(true,StatusCode.OK,"ok");
   }
   @RequestMapping(value = "/deletegp/{id}",method = RequestMethod.GET)
    public Result deletegp(@PathVariable int id){
        serviceService.deletegp(id);
        return new Result(true,StatusCode.OK,"ok");
   }
   @RequestMapping(value = "/deletep/{id}",method = RequestMethod.GET)
    public Result deleltep(@PathVariable int id){
        serviceService.deletep(id);
        return new Result(true,StatusCode.OK,"ok");
   }

    @RequestMapping(value = "/supplier",method = RequestMethod.POST)
    public Result suppluer(@RequestBody Particulars particulars){
        serviceService.supplier(particulars);
        return new Result(true,StatusCode.OK,"ok");
    }
//    @RequestMapping(value = "/updatesupplier",method = RequestMethod.POST)
//    public Result updatesupplier(@RequestBody Particulars particulars){
//        serviceService.updateSupplier(particulars);
//        return new Result(true,StatusCode.OK,"ok");
//    }

}
