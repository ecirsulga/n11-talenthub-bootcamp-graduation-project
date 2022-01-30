package com.ecirsulga.n11finalproject.usercredit.dao;

import com.ecirsulga.n11finalproject.usercredit.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<User, Long> {

    @Query("select user from User user where user.phoneNumber = ?1")
    User findUserByUserPhone(String userPhone);

    @Query("select user from User user where user.idNumber = ?1")
    User findUserByUserIdNumber(String userIdNumber);

}
