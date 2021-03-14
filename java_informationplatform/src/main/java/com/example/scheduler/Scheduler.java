package com.example.scheduler;


import com.example.install.mapper.ContractMapper;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class Scheduler {

     @Resource
     private ContractMapper contractMapper;

    ;

    @Scheduled(cron = "0 0 0/2 * * ?") //一分钟
    public void deleteCheck(){
        //System.out.println("开始执行");
       String dateCheck = "2017-12-30 00:00:00.0";
       // System.out.println(dateCheck);
        contractMapper.deleteCheck(dateCheck);
        System.out.println("执行结束");
    }
}
