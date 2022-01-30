package com.ecirsulga.n11finalproject.usercredit.dto;

import com.ecirsulga.n11finalproject.usercredit.enums.EnumCreditResult;
import com.sun.istack.Nullable;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Getter
@Setter
public class UserCreditSavedDto {
    private Long userId;

    private EnumCreditResult creditResult;

    @Temporal(TemporalType.TIMESTAMP)
    private Date updateDate;

    private Long creditAmount;

    private String idNumber;

    private String name;

    private String surname;

    private String phoneNumber;

    @Temporal(TemporalType.TIMESTAMP)
    private Date birthDate;

    private Long monthlySalary;

    @Nullable
    private Long assurance;
}
