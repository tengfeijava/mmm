package com.example.user.controller;


import com.example.user.pojo.Clerk;
import com.example.user.service.ClerkService;
import com.example.utils.Result;
import com.example.utils.StatusCode;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/clerk")
public class ClerkController {

    @Resource
    private ClerkService clerkService;

    @RequestMapping(value = "/clerkfindAll",method = RequestMethod.GET)
    public Result clerkfindAll(){
        List<Clerk> list = clerkService.clerkfindAll();
        return new Result(true, StatusCode.OK,"ok",list);
    }
    @RequestMapping(value = "/insertClerk",method = RequestMethod.POST)
    public Result insertClerk(@RequestBody Clerk clerk){
        clerkService.insertClert(clerk);
        return new Result(true,StatusCode.OK,"ok");
    }
    @RequestMapping(value = "/updateClerk",method = RequestMethod.POST)
    public Result updateClerk(@RequestBody Clerk clerk){
        clerkService.upateClert(clerk);
        return new Result(true,StatusCode.OK,"ok");
    }
    @RequestMapping(value = "/deleteClerk/{id}",method = RequestMethod.GET)
    public Result deleteClerk(@PathVariable int id){
        clerkService.deleteClerk(id);
        return new Result(true,StatusCode.OK,"ok");
    }
}
