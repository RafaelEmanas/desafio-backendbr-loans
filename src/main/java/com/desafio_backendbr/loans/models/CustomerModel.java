package com.desafio_backendbr.loans.models;


import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "TB_CUSTOMER")
public class CustomerModel implements Serializable {

    public CustomerModel(){}

    public CustomerModel(
        String cpf,
        Integer age,
        String name,
        BigDecimal income,
        String location
    ) {
        this.cpf = cpf;
        this.age = age;
        this.name = name;
        this.income = income;
        this.location = location;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID personId;

    @Column(unique = true)
    private String cpf;

    private Integer age;
    private String name;
    private BigDecimal income;
    private String location;

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getIncome() {
        return income;
    }

    public void setIncome(BigDecimal income) {
        this.income = income;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

}
