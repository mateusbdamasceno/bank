package com.project.beans;

import lombok.Data;


@Data
public class Transaction {


    private long id;

    private String code;

    private String name;

    private String descricao;
}
