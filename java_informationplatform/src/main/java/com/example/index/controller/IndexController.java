package com.example.index.controller;


import com.example.index.pojo.*;
import com.example.index.service.IndexService;
import com.example.utils.R;
import com.example.utils.Result;
import com.example.utils.StatusCode;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.lang.ref.PhantomReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/index")
public class IndexController {

    @Resource
    private IndexService indexService;



    @RequestMapping(value = "/startAll",method = RequestMethod.GET)
    public R startAll(){

        List<Todoindex> indexList = indexService.startAll();
        Install install = indexService.installCollect();
        Sell sell = indexService.sellCollect();
        Maintain maintain =indexService.maintainCollect();
        List<Bigbrand> list =indexService.children();
        List<Points> pointsList = indexService.pointsAll();
        List<Brandlog> maintainBrand = indexService.maintainBrand();
        List<Brandlog> sellbrand = indexService.sellBrand();

        R r = new R();
        r.put("Todoindex",indexList);    //计划
        r.put("constpoints",pointsList);//坐标
        r.put("children",list);        // 品牌Tree
        r.put("Install",install);      //安装
        r.put("Sell",sell);           //销售
        r.put("Maintain",maintain);  //维保
        r.put("maintainBrand",maintainBrand); //维保品牌
        r.put("sellBrand",sellbrand);  //销售品牌
        return r;
    }
    @RequestMapping(value = "/updeteIndex",method = RequestMethod.POST)
    public Result updeteIndex(@RequestBody Todoindex todoindex){
        indexService.updeteIndex(todoindex);
        return new Result(true,StatusCode.OK,"ok");
    }
    @RequestMapping(value = "/deletelIndex/{id}",method = RequestMethod.GET)
    public Result deletelIndex(@PathVariable int id){
        indexService.deletelIndex(id);
        return new Result(true,StatusCode.OK,"ok");
    }
    @RequestMapping(value = "/InsertIndex",method = RequestMethod.POST)
    public Result insertIndex(@RequestBody Todoindex todoindex){
        indexService.insertIndex(todoindex);
        return new Result(true,StatusCode.OK,"ok");
    }

    @RequestMapping(value = "/arrdelete",method = RequestMethod.GET)
    public Result arrdelete(@RequestParam(value = "gpid") String gpid){
        String[] gpids = gpid.split(",");
        List<Integer> list = new ArrayList<>();
        for (String s : gpids) {
            list.add(Integer.parseInt(s));
        }
         indexService.arrdelete(list);
        return new Result(true,StatusCode.OK,"ok");
    }
}
