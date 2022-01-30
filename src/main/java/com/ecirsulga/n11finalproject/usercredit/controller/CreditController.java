package com.ecirsulga.n11finalproject.usercredit.controller;

import com.ecirsulga.n11finalproject.usercredit.entity.Credit;
import com.ecirsulga.n11finalproject.usercredit.entity.User;
import com.ecirsulga.n11finalproject.usercredit.service.CreditEntityService;
import com.ecirsulga.n11finalproject.usercredit.service.UserEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/credits")
@RequiredArgsConstructor
public class CreditController {

    @Autowired
    private final CreditEntityService creditEntityService;

    @GetMapping("")
    public ResponseEntity findAll(){
        List<Credit> credits = creditEntityService.findAll();
        return ResponseEntity.ok(credits);
    }

    @GetMapping("/inquire/{userPhone}/{userIdNumber}")
    public ResponseEntity findByPhoneAndIdNumber(@PathVariable String userPhone, @PathVariable String userIdNumber){
        Credit credit = creditEntityService.getByUserIdNumberAndPhone(userPhone,userIdNumber);
        return ResponseEntity.ok(credit);
    }

}
