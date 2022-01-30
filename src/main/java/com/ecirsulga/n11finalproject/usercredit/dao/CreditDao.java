package com.ecirsulga.n11finalproject.usercredit.dao;

import com.ecirsulga.n11finalproject.usercredit.entity.Credit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditDao extends JpaRepository<Credit, Long> {

    @Query("select credit from Credit credit where credit.userId = ?1")
    Credit findCreditByUserId(Long userId);

}
