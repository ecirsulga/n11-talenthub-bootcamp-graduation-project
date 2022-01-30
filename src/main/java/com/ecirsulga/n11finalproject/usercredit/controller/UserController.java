package com.ecirsulga.n11finalproject.usercredit.controller;

import com.ecirsulga.n11finalproject.usercredit.dto.UserCreditSavedDto;
import com.ecirsulga.n11finalproject.usercredit.entity.User;
import com.ecirsulga.n11finalproject.usercredit.service.UserEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    @Autowired
    private final UserEntityService userEntityService;

    @GetMapping("")
    public ResponseEntity findAll(){
        List<User> dbtDebts = userEntityService.findAll();
        return ResponseEntity.ok(dbtDebts);
    }

    @PostMapping
    public ResponseEntity create(@RequestBody User user){
        UserCreditSavedDto userCreditSavedDto = userEntityService.save(user);
        return ResponseEntity.ok(userCreditSavedDto);
    }

}
