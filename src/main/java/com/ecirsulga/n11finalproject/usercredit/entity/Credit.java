package com.ecirsulga.n11finalproject.usercredit.entity;

import com.ecirsulga.n11finalproject.usercredit.enums.EnumCreditResult;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "CREDIT")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Credit {

    @Id
    @GeneratedValue
    private Long id;

    private Long userId;

    private EnumCreditResult creditResult;

    @Temporal(TemporalType.TIMESTAMP)
    private Date updateDate;

    private Long creditAmount;

}
