package com.example.springboothw27.repstiotry;

import com.example.springboothw27.model.MyUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthRepstory extends JpaRepository<MyUser,Integer> {
    MyUser findMyUserByUsername(String username);
}
