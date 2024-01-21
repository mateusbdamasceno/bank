package com.project.beans;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;


@Data
public class Transaction {

    private long id;
    private String sourceAccount;
    private String targetAccount;
    private BigDecimal value;
    private BigDecimal  rate;
    private Date transferDate;
    private Date schedulingDate;
    private String description;
}
