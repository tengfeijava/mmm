package com.example.user.service;

import com.example.user.mapper.ClerkMapper;
import com.example.user.pojo.Clerk;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ClerkService {

    @Resource
    private ClerkMapper clerkMapper;

    public List<Clerk> clerkfindAll() {
        return clerkMapper.clerkfindAll();
    }

    public void insertClert(Clerk clerk) {
        clerkMapper.insertClerk(clerk);
    }

    public void upateClert(Clerk clerk) {
        clerkMapper.updateClerk(clerk);
    }

    public void deleteClerk(int id) {
        clerkMapper.deleteClert(id);
    }
}
