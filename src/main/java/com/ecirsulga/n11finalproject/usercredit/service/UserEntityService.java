package com.ecirsulga.n11finalproject.usercredit.service;


import com.ecirsulga.n11finalproject.usercredit.dao.UserDao;
import com.ecirsulga.n11finalproject.usercredit.dto.UserCreditSavedDto;
import com.ecirsulga.n11finalproject.usercredit.entity.Credit;
import com.ecirsulga.n11finalproject.usercredit.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class UserEntityService {

    @Autowired
    private UserDao userDao;
    @Autowired
    private CreditEntityService creditEntityService;


    public List<User> findAll(){
        return (List<User>) userDao.findAll();
    }

    public UserCreditSavedDto save(User user){
        user = userDao.save(user);
        Credit credit = creditEntityService.CalculateAndSaveCredit(user);
        UserCreditSavedDto userCreditSavedDto = new UserCreditSavedDto();
        userCreditSavedDto.setIdNumber(user.getIdNumber());
        userCreditSavedDto.setAssurance(user.getAssurance());
        userCreditSavedDto.setBirthDate(user.getBirthDate());
        userCreditSavedDto.setCreditAmount(credit.getCreditAmount());
        userCreditSavedDto.setCreditResult(credit.getCreditResult());
        userCreditSavedDto.setMonthlySalary(user.getMonthlySalary());
        userCreditSavedDto.setName(user.getName());
        userCreditSavedDto.setSurname(user.getSurname());
        userCreditSavedDto.setUserId(user.getId());
        userCreditSavedDto.setUpdateDate(credit.getUpdateDate());
        userCreditSavedDto.setPhoneNumber(user.getPhoneNumber());
        return userCreditSavedDto;
    }

    public void deleteById(Long id){
        userDao.deleteById(id);
    }


}
