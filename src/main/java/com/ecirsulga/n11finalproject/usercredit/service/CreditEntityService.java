package com.ecirsulga.n11finalproject.usercredit.service;


import com.ecirsulga.n11finalproject.usercredit.dao.CreditDao;
import com.ecirsulga.n11finalproject.usercredit.dao.UserDao;
import com.ecirsulga.n11finalproject.usercredit.entity.Credit;
import com.ecirsulga.n11finalproject.usercredit.entity.User;
import com.ecirsulga.n11finalproject.usercredit.enums.EnumCreditResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Transactional
@Service
public class CreditEntityService {

    @Autowired
    private CreditDao creditDao;
    @Autowired
    private UserDao userDao;


    public List<Credit> findAll(){
        return (List<Credit>) creditDao.findAll();
    }

    public Credit CalculateAndSaveCredit(User user)
    {
        Random r = new Random();
        int low = 10;
        int high = 1000;
        int creditScore = r.nextInt(high-low) + low;
        Credit credit = new Credit();
        credit.setUpdateDate(Date.from(Instant.now()));
        credit.setUserId(user.getId());
        Long creditAmount = 0L;
        if(creditScore < 500)
        {
            creditAmount = 0L;
            credit.setCreditResult(EnumCreditResult.DENIED);
        }
        else if(creditScore < 1000)
        {
            if(user.getMonthlySalary() < 5000L)
            {
                creditAmount = 10000L;
                if(user.getAssurance() != null )
                    creditAmount +=user.getAssurance()*10L/100;
                credit.setCreditResult(EnumCreditResult.ACCEPTED);
            }
            else if(user.getMonthlySalary() < 10000L)
            {
                creditAmount = 20000L;
                if(user.getAssurance() != null )
                    creditAmount +=user.getAssurance()*20L/100;
                credit.setCreditResult(EnumCreditResult.ACCEPTED);
            }
            else
            {
                creditAmount = user.getMonthlySalary()*4L/2L;
                if(user.getAssurance() != null )
                    creditAmount +=user.getAssurance()*25L/100;
                credit.setCreditResult(EnumCreditResult.ACCEPTED);
            }
        }
        else {
            creditAmount = user.getMonthlySalary()*4L;
            if(user.getAssurance() != null )
                creditAmount +=user.getAssurance()*50L/100;
            credit.setCreditResult(EnumCreditResult.ACCEPTED);
        }
        credit.setCreditAmount(creditAmount);

        return creditDao.save(credit);
    }

    public Credit getByUserIdNumberAndPhone(String userPhone,String userIdNumber)
    {
        User firstFoundUser = userDao.findUserByUserPhone(userPhone);
        User secondFoundUser = userDao.findUserByUserIdNumber(userIdNumber);
        if(firstFoundUser == null)
            throw new RuntimeException(userPhone + " kullanici telefon nosu ile aranan kullanıcı databasede bulunamadı !");
        if(secondFoundUser == null)
            throw new RuntimeException(userIdNumber + " kullanici kimlik numarası ile aranan kullanıcı databasede bulunamadı !");
        if(firstFoundUser.getId() != secondFoundUser.getId())
            throw new RuntimeException(userPhone + " kullanici telefon nosu ile " + userIdNumber +" kimlik numarası bilgileri uyuşmamaktadır.");

        return creditDao.findCreditByUserId(firstFoundUser.getId());

    }

}
