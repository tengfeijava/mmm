package com.example.user.mapper;


import com.example.user.pojo.Clerk;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ClerkMapper {
    List<Clerk> clerkfindAll();

    void insertClerk(Clerk clerk);

    void updateClerk(Clerk clerk);

    void deleteClert(int id);
}
